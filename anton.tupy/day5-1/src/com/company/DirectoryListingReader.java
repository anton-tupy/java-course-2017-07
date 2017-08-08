package com.company;

import java.util.List;

/**
 * Created by IT-Academy on 05.08.2017.
 */
public interface DirectoryListingReader {
    List<DirectoryItem> read() throws DirectoryPrinterException;
}
