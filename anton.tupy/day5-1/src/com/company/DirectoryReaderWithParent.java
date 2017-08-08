package com.company;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IT-Academy on 05.08.2017.
 */
public class DirectoryReaderWithParent implements DirectoryListingReader {

    private String currentDir;
    private DirectoryListingReader listingReader;

    public DirectoryReaderWithParent(
            String currentDir, DirectoryListingReader listingReader) {
        this.currentDir = currentDir;
        this.listingReader = listingReader;
    }

    @Override
    public List<DirectoryItem> read() throws DirectoryPrinterException {
        List<DirectoryItem> items = listingReader.read();

        Path currentPath = Paths.get(currentDir).toAbsolutePath();
        Path parent = currentPath.getParent();
        if (parent == null) {
            return items;
        }
        parent = parent.getParent();
        if (parent == null) {
            return items;
        }
        String parentStr = parent.toString();
        DirectoryItem parentItem = DirectoryItem.directory("..", parentStr);

        ArrayList<DirectoryItem> result = new ArrayList<>();
        result.add(parentItem);
        result.addAll(items);

        return result;
    }
}
