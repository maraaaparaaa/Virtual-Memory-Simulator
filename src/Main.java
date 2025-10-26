public class Main {
    public static void main(String[] args) {
        Simulator sim = new Simulator(3, 5); // RAM with 3 frames, 5 virtual pages
        int[] pageSequence = {0, 1, 2, 0, 3, 0, 4, 2};

        for (int pageId : pageSequence) {
            sim.accessPage(pageId);
        }

        sim.printStats();
    }
}
