package org.virtualmemory.model;

public class PageTable {
    Page[] pages; // all vitual pages

    public PageTable(int numPages) {
        pages = new Page[numPages];
        for (int i = 0; i < numPages; i++) {
            pages[i] = new Page(i);
        }
    }

    public Page getPage(int id) {
        return pages[id];
    }
}
