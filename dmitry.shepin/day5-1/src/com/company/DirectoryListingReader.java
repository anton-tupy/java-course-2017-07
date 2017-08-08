package com.company;

import java.util.List;

public interface DirectoryListingReader {
    List<DirectoryItem> read() throws DirectoryPrinterException;
}
