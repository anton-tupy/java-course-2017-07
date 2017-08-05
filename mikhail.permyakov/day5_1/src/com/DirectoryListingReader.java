package com;

import java.util.List;

public interface DirectoryListingReader {
    List<DirectoryItem> read() throws DirectoryPrinterException;
}
