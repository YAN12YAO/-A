package a1_3;

import java.util.ArrayList;
import java.util.List;

/**
 * 学院。由 1 到多个系构成（组合 School 1 —— Department 1..*），
 * 并拥有 0 到多名学生（School 1 —— Student 0..*）。
 */
public class School {
    private String name;
    private String address;
    private final List<Department> departments = new ArrayList<>();
    private final List<Student> students = new ArrayList<>();

    public School(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Department addDepartment(String deptName, String office) {
        Department d = new Department(deptName, office);
        d.setSchool(this);
        departments.add(d);
        return d;
    }

    public Student addStudent(String sno, String name, String major) {
        Student s = new Student(sno, name, major);
        s.setSchool(this);
        students.add(s);
        return s;
    }

    public List<Department> getDepartments() { return departments; }
    public List<Student> getStudents() { return students; }
    public String getName() { return name; }

    public void checkMultiplicity() {
        if (departments.isEmpty()) {
            throw new IllegalStateException(name + " 至少由 1 个系构成（1..*）");
        }
    }

    @Override
    public String toString() {
        return "School{" + name + ", 系 " + departments.size() + " 个, 学生 " + students.size() + " 人}";
    }
}
