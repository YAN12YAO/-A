package a1_3;

import java.util.ArrayList;
import java.util.List;

/** 学生。参加 1~5 门课程学习（Student —— Subject 1..5）。 */
public class Student {
    private String sno;
    private String name;
    private String major;
    private School school;
    private final List<Subject> subjects = new ArrayList<>();

    public Student(String sno, String name, String major) {
        this.sno = sno;
        this.name = name;
        this.major = major;
    }

    void setSchool(School school) { this.school = school; }

    public void enroll(Subject s) {
        if (subjects.size() >= 5 && !subjects.contains(s)) {
            throw new IllegalStateException(name + " 最多选修 5 门课程（多重性 1..5）");
        }
        if (!subjects.contains(s)) {
            subjects.add(s);
        }
    }

    public List<Subject> getSubjects() { return subjects; }

    public void checkMultiplicity() {
        if (subjects.isEmpty()) {
            throw new IllegalStateException(name + " 至少选修 1 门课程（多重性 1..5）");
        }
    }

    public String getName() { return name; }
    public String getSno() { return sno; }

    @Override
    public String toString() { return sno + " " + name + "（" + major + "）"; }
}
