package com.company;

import java.util.List;

/**
 * Created by IT-Academy on 05.08.2017.
 */
public class DirectorySortingReader implements DirectoryListingReader {

    private DirectoryListingReader listingReader;

    public DirectorySortingReader(DirectoryListingReader listingReader) {
        this.listingReader = listingReader;
    }

    @Override
    public List<DirectoryItem> read() throws DirectoryPrinterException {
        List<DirectoryItem> items = listingReader.read();
        items.sort((item1, item2) -> {
            if (item1.getType() == DirectoryItem.DirectoryItemType.DIRECTORY &&
                    item2.getType() == DirectoryItem.DirectoryItemType.FILE) {
                return -1;
            }
            if (item1.getType() == DirectoryItem.DirectoryItemType.FILE &&
                    item2.getType() == DirectoryItem.DirectoryItemType.DIRECTORY) {
                return 1;
            }
            return item1.getName().compareToIgnoreCase(item2.getName());
        });
        return items;
    }
}
