public class Antinode {
    private static int instanceCount = 0;
    int x = 0;
    int y = 0;
    public Antinode(int x, int y) {
        this.x = x;
        this.y = y;
        instanceCount++;
    }

    public static int getInstanceCount() {
        return instanceCount;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
}
