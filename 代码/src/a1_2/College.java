package a1_2;

import java.util.ArrayList;
import java.util.List;

/**
 * 学院。
 * 与 Building 是聚合关系（空心菱形，College 1 —— Building 1..*）：建筑构成学院，但建筑可独立存在；
 * 与 Course 是组合关系（实心菱形，College 1 —— Course 1..*）：课程由学院开设，学院撤销后课程不再存在。
 */
public class College {
    private String name;
    private String address;
    /** 聚合：只保存引用，不负责建筑的生命周期 */
    private final List<Building> buildings = new ArrayList<>();
    /** 组合：由学院负责创建与销毁 */
    private final List<Course> courses = new ArrayList<>();

    public College(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void addBuilding(Building b) {
        buildings.add(b);
    }

    /** 组合语义：学院自己"造"课程，外部不能把课程对象塞给学院 */
    public Course addCourse(String code, String title, int credit, Building building) {
        if (!buildings.contains(building)) {
            throw new IllegalArgumentException("约束被破坏：课程所在建筑必须属于本学院");
        }
        Course c = new Course(code, title, credit, building);
        courses.add(c);
        return c;
    }

    /** 组合语义：学院撤销时课程随之销毁，而建筑作为聚合对象仍然保留 */
    public void close() {
        for (Course c : courses) {
            System.out.println("  课程 " + c.getCode() + " 随学院撤销而销毁");
        }
        courses.clear();
        System.out.println("  学院撤销完成；建筑仍独立存在：" + buildings);
    }

    public String getName() { return name; }
    public String getAddress() { return address; }
    public List<Building> getBuildings() { return buildings; }
    public List<Course> getCourses() { return courses; }

    @Override
    public String toString() {
        return "College{" + name + ", 建筑 " + buildings.size() + " 栋, 课程 " + courses.size() + " 门}";
    }
}
