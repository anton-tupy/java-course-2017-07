package com.company;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DirectoryReader implements DirectoryListingReader {
    private String dirPath;

    public DirectoryReader(String dirPath) {
        this.dirPath = dirPath;
    }

    public List<DirectoryItem> read() throws DirectoryPrinterException {

        try {

            ArrayList<DirectoryItem> result = new ArrayList<>();
            Path dir = Paths.get(dirPath);

            try (Stream<Path> dirList = Files.list(dir)) {

                dirList.forEach((Path itemPath) -> {

                    String name = itemPath.getFileName().toString();
                    String fullPath = itemPath.toAbsolutePath().getFileName().toString();
                    DirectoryItem directoryItem;

                    if (Files.isDirectory(itemPath)) {
                        directoryItem = DirectoryItem.directory(name, fullPath);
                    } else {
                        Long size = tryGet(() -> Files.size(itemPath));

                        OffsetDateTime changedAtDateTime = tryGet(() -> {
                            FileTime lastModifiedTime = Files.getLastModifiedTime(itemPath);
                            Instant changeAt = Instant.ofEpochMilli(lastModifiedTime.toMillis());

                            return OffsetDateTime.ofInstant(changeAt, ZoneId.systemDefault());
                        });

                        directoryItem = DirectoryItem.file(name, fullPath, size, changedAtDateTime);

                    }
                    result.add(directoryItem);
                });

            }
            return result;

        } catch (IOException e) {
            throw new DirectoryPrinterException(
                    "Unable to read directory", e);
        }
    }

    public interface Task<T> {
        T get() throws IOException;
    }

    private <T> T tryGet(Task<T> task) {
        try {
            return task.get();
        } catch (IOException e) {
            e.printStackTrace(System.err);
            return null;
        }
    }
}
