public class Page {
    int id;
    boolean inRAM;
    int frameIndex; // index fram in RAM (-1 if it's not in RAM)

    public Page(int id) {
        this.id = id;
        this.inRAM = false;
        this.frameIndex = -1;
    }

    @Override
    public String toString() {
        return "Page" + id + (inRAM ? " in RAM" : "on disk");
    }
}
