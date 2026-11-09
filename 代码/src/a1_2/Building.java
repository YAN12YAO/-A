package a1_2;

/** 建筑。学院聚合的对象，即使学院撤销，建筑本身仍可独立存在。 */
public class Building {
    private String number;
    private int capacity;

    public Building(String number, int capacity) {
        this.number = number;
        this.capacity = capacity;
    }

    public String getNumber() { return number; }
    public int getCapacity() { return capacity; }

    @Override
    public String toString() {
        return "Building{" + number + ", 容量 " + capacity + "}";
    }
}
