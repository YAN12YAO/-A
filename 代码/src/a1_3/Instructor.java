package a1_3;

import java.util.ArrayList;
import java.util.List;

/**
 * 指导教师。多重性：必须且只能属于 1 个系（Department 1 —— Instructor 1..*），
 * 并教授 1~3 门课程（Instructor —— Subject 1..3）。
 */
public class Instructor {
    private String name;
    private String title;
    /** 所属系，1 个 */
    private Department department;
    /** 所授课程，1~3 门 */
    private final List<Subject> subjects = new ArrayList<>();

    public Instructor(String name, String title) {
        this.name = name;
        this.title = title;
    }

    void setDepartment(Department department) { this.department = department; }

    public Department getDepartment() { return department; }

    public void teach(Subject s) {
        if (subjects.size() >= 3 && !subjects.contains(s)) {
            throw new IllegalStateException(name + " 最多教授 3 门课程（多重性 1..3）");
        }
        if (!subjects.contains(s)) {
            subjects.add(s);
        }
    }

    public List<Subject> getSubjects() { return subjects; }

    /** 校验 1~3 门课程的下界 */
    public void checkMultiplicity() {
        if (subjects.isEmpty()) {
            throw new IllegalStateException(name + " 至少教授 1 门课程（多重性 1..3）");
        }
    }

    public String getName() { return name; }

    @Override
    public String toString() { return name + "（" + title + "）"; }
}
