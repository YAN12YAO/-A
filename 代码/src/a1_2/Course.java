package a1_2;

/**
 * 课程。与学院是组合关系（学院消亡则课程失去存在意义）；
 * 同时受到约束 {Course 一定在某个 Building 中进行}：
 * 因此构造课程时必须绑定一栋建筑，null 直接拒绝。
 */
public class Course {
    private String code;
    private String title;
    private int credit;
    /** 约束 {Course 一定在某个 Building 中进行} 的落地实现 */
    private Building building;

    public Course(String code, String title, int credit, Building building) {
        if (building == null) {
            throw new IllegalArgumentException("约束被破坏：Course 一定在某个 Building 中进行");
        }
        this.code = code;
        this.title = title;
        this.credit = credit;
        this.building = building;
    }

    public String getCode() { return code; }
    public String getTitle() { return title; }
    public int getCredit() { return credit; }
    public Building getBuilding() { return building; }

    public void setBuilding(Building building) {
        if (building == null) {
            throw new IllegalArgumentException("约束被破坏：Course 一定在某个 Building 中进行");
        }
        this.building = building;
    }

    @Override
    public String toString() {
        return "Course{" + code + " " + title + ", " + credit + " 学分, 地点 " + building.getNumber() + "}";
    }
}
