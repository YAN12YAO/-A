package a1_3;

import java.util.ArrayList;
import java.util.List;

/**
 * 系。每个系至少拥有 1 位指导教师、至少提供 1 门课程
 * （Department 1 —— Instructor 1..*，Department 1 —— Subject 1..*）。
 */
public class Department {
    private String name;
    private String office;
    private School school;
    private final List<Instructor> instructors = new ArrayList<>();
    private final List<Subject> subjects = new ArrayList<>();

    public Department(String name, String office) {
        this.name = name;
        this.office = office;
    }

    void setSchool(School school) { this.school = school; }

    public School getSchool() { return school; }

    public Instructor addInstructor(String name, String title) {
        Instructor i = new Instructor(name, title);
        i.setDepartment(this);
        instructors.add(i);
        return i;
    }

    public Subject addSubject(String code, String title, int credit) {
        Subject s = new Subject(code, title, credit);
        subjects.add(s);
        return s;
    }

    public List<Instructor> getInstructors() { return instructors; }
    public List<Subject> getSubjects() { return subjects; }
    public String getName() { return name; }

    public void checkMultiplicity() {
        if (instructors.isEmpty()) {
            throw new IllegalStateException(name + " 至少拥有 1 位指导教师（1..*）");
        }
        if (subjects.isEmpty()) {
            throw new IllegalStateException(name + " 至少提供 1 门课程（1..*）");
        }
    }

    @Override
    public String toString() {
        return name + "{教师 " + instructors.size() + " 人, 课程 " + subjects.size() + " 门}";
    }
}
