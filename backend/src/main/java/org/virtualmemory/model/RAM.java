package org.virtualmemory.model;

import java.util.LinkedList;
import java.util.Queue;

public class RAM {
    int size; // frame number
    Page[] frames; // pages in RAM
    Queue<Integer> fifoQueue;

    public RAM(int size) {
        this.size = size;
        this.frames = new Page[size];
        this.fifoQueue = new LinkedList<>();
    }

    public boolean isFull(){
        for(Page p : frames){
            if (p==null) return false;
        }
        return true;
    }

    public void addPage(Page p){
        if(!isFull()){
            //find first empty frame
            for(int i=0;i<size;i++){
                if(frames[i]==null){
                    frames[i] = p;
                    fifoQueue.add(i);
                    p.inRAM = true;
                    p.frameIndex = i;
                    break;
                }
            }
        }else{
            // full RAM -> FIFO replacement
            int frameToReplace = fifoQueue.poll();// takes the first page
            Page oldPage = frames[frameToReplace];
            oldPage.inRAM = false;
            oldPage.frameIndex = -1;

            frames[frameToReplace] = p;
            p.inRAM = true;
            p.frameIndex = frameToReplace;
            fifoQueue.add(frameToReplace);
        }
    }

    public void printMemory() {
        System.out.print("RAM: ");
        for (Page p : frames) {
            if (p != null) System.out.print(p.id + " ");
            else System.out.print("- ");
        }
        System.out.println();
    }

    public Page[] getFrames() {
        return frames;
    }

    public int getSize() {
        return size;
    }
}
