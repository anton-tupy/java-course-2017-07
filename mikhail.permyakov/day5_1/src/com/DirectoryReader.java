package com;

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
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.nio.file.Files.list;

public class DirectoryReader implements DirectoryListingReader{
    private String dirPath;

    public DirectoryReader(String dirPath) {
        this.dirPath = dirPath;
    }

    public List<DirectoryItem> read() throws DirectoryPrinterException{
               try {
                   ArrayList<DirectoryItem> result = new ArrayList<>();
                   Path dir = Paths.get(dirPath);
                   try(Stream<Path> dirList = Files.list(dir)){
                       dirList.forEach(itemPath -> {
                           String name = itemPath.getFileName().toString();
                           String fullPath = itemPath.getFileName().toAbsolutePath().toString();
                           DirectoryItem directoryItem;
                           if (Files.isDirectory(itemPath)) {
                               directoryItem = DirectoryItem.directory(itemPath.toString(),
                                       itemPath.toAbsolutePath().toString());
                           } else {
                               Long size = DirectoryReader.this.tryGet(() -> Files.size(itemPath));

//                               try {
//                                   size = Files.size(itemPath);
//                               } catch (IOException e){
//                                   e.printStackTrace(System.err);
//                                   size = null;
//                               }
                               OffsetDateTime createdAtDateTime =
                                       DirectoryReader.this.tryGet(() -> {
                                           FileTime lastModifiedTime = Files.getLastModifiedTime(itemPath);
                                           Instant changedAt = Instant.ofEpochMilli(lastModifiedTime.toMillis());
                                           return OffsetDateTime.ofInstant(changedAt, ZoneId.systemDefault());
                                       });


//                               try {
//                                   lastModifiedTime = Files.getLastModifiedTime(itemPath);
//                               } catch (IOException e){
//                                   e.printStackTrace(System.err);
//                                   lastModifiedTime = null;
//                               }
                               directoryItem =
                                       DirectoryItem.file(name, fullPath, size, createdAtDateTime);

                           }
                           result.add(directoryItem);
                       });//end of lambda
                   }
                   return result;

               } catch (IOException e) {
            throw new DirectoryPrinterException();
        }
    }

    public interface Task<T>{
        T get() throws IOException;
    }
    private <T> T tryGet(Task<T> task){
        try {
            return task.get();
        }catch(IOException e){
            e.printStackTrace(System.err);
            return null;

        }
    }
}
