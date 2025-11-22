package org.virtualmemory.model;

import java.util.Queue;

public class Simulator {
    RAM memory;
    PageTable pageTable;
    int hits = 0;
    int faults = 0;

    public Simulator(int numFrames, int numPages) {
        memory = new RAM(numFrames);
        pageTable = new PageTable(numPages);
    }

    public void accessPage(int pageId){
        // Checks if the page is in RAM
        // If not, page fault -> adds the page in RAM
        // If Ram is full, replaces a page
        Page p = pageTable.getPage(pageId);
        if (p.inRAM) {
            hits++;
            System.out.println("HIT: Page " + pageId);
        } else {
            faults++;
            System.out.println("PAGE FAULT: Page " + pageId);
            memory.addPage(p);
        }
        memory.printMemory();
    }

    public void printStats() {
        System.out.println("Hits: " + hits + ", Page Faults: " + faults);
    }

    public RAM getMemory() {
        return memory;
    }

    public int getHits() {
        return hits;
    }

    public int getFaults() {
        return faults;
    }
}
