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

/**
 * Created by IT-Academy on 03.08.2017.
 */
public class DirectoryReader {
    private String dirPath;

    public DirectoryReader(String dirPath) {
        this.dirPath = dirPath;
    }

    public List<DirectoryItem> read()
            throws DirectoryPrinterException {
        try {
            ArrayList<DirectoryItem> result = new ArrayList<>();
            Path dir = Paths.get(dirPath);
            try (Stream<Path> dirList = Files.list(dir)) {
                dirList.forEach(itemPath -> {
                    String name = itemPath.getFileName().toString();
                    String fullPath = itemPath.getFileName().toAbsolutePath().toString();
                    DirectoryItem directoryItem;
                    if (Files.isDirectory(itemPath)) {
                        directoryItem = DirectoryItem.directory(name, fullPath);
                    }
                    else {
                        try {
                            long size = Files.size(itemPath);
                            FileTime lastModifiedTime = Files.getLastModifiedTime(itemPath);
                            Instant changedAt = Instant.ofEpochMilli(lastModifiedTime.toMillis());
                            OffsetDateTime changedAtDateTime =
                                    OffsetDateTime.ofInstant(changedAt, ZoneId.systemDefault());
                            directoryItem =
                                    DirectoryItem.file(
                                            name, fullPath, size, changedAtDateTime);
                        }
                        catch (IOException e) {
                            throw new RuntimeException(e);
                        }
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
}
