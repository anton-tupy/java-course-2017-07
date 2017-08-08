package com.company;

import java.time.OffsetDateTime;

public class DirectoryItem {

    private String name;
    private String path;
    private DirectoryItemType type;
    private Long size;
    private OffsetDateTime changeAt;

    private DirectoryItem(String name, String path, DirectoryItemType type, Long size, OffsetDateTime createdAt) {
        this.name = name;
        this.path = path;
        this.type = type;
        this.size = size;
        this.changeAt = createdAt;
    }

    public enum DirectoryItemType {
        FILE,
        DIRECTORY,
    }

    public static DirectoryItem file(String name, String path, Long size, OffsetDateTime createdAt) {
        return new DirectoryItem(name, path, DirectoryItemType.FILE, size, createdAt);
    }

    public static DirectoryItem directory(String name, String path) {
        return new DirectoryItem(name, path, DirectoryItemType.DIRECTORY, null, null);
    }


    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public DirectoryItemType getType() {
        return type;
    }

    public Long getSize() {
        return size;
    }

    public OffsetDateTime getCreatedAt() {
        return changeAt;
    }

    @Override
    public String toString() {
        return "DirectoryItem{" +
                "name='   " + name + '\'' +
                "     ,path='   " + path + '\'' +
                "    ,type=  " + type +
                "    ,size=   " + size +
                "    ,changeAt=   " + changeAt +
                '}';
    }


}
