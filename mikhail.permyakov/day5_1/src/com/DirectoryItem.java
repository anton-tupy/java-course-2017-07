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

    static DirectoryItem file(String name, String path, Long size, OffsetDateTime changedAt){
        return new DirectoryItem(name, path, DirectoryItemType.FILE, size, changedAt);
    }

    static DirectoryItem directory(String name, String path){
        return new DirectoryItem(name, path, DirectoryItemType.DIRECTORY, null, null);
    }

    String getName() {
        return name;
    }

    String getPath() {
        return path;
    }

    DirectoryItemType getType() {
        return type;
    }

    Long getSize() {
        return size;
    }

    OffsetDateTime getChangedAt() {
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

    private DirectoryItem(String name, String path, DirectoryItemType type, Long size, OffsetDateTime changedAt) {
        this.name = name;
        this.path = path;
        this.type = type;
        this.size = size;
        this.changedAt = changedAt;
    }
}
