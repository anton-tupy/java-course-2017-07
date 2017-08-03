package com;

import java.time.OffsetDateTime;

public class DirectoryItem {
    public enum DirectoryItemType {
        FILE,
        DIRECTORY
    }
    private String name;
    private String path;
    private DirectoryItemType type;
    private Long size;
    private OffsetDateTime changedAt;

    public static DirectoryItem file(String name, String path, long size, OffsetDateTime changedAt){
        return new DirectoryItem(name, path, DirectoryItemType.FILE, size, changedAt);
    }

    public static DirectoryItem directory(String name, String path){
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

    public OffsetDateTime getChangedAt() {
        return changedAt;
    }

    @Override
    public String toString() {
        return "DirectoryItem{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", type=" + type +
                ", size=" + size +
                ", changedAt=" + changedAt +
                '}';
    }

    private DirectoryItem(String name, String path, DirectoryItemType type, Long size, OffsetDateTime createdAt) {
        this.name = name;
        this.path = path;
        this.type = type;
        this.size = size;
        this.changedAt = createdAt;
    }
}
