package a1_3;

/** A1-3 测试：按类图建立一所学院，并检验各多重性约束。 */
public class Demo {
    public static void main(String[] args) {
        School school = new School("人工智能与计算机学院", "三峡大学");
        Department cs = school.addDepartment("计算机系", "B3-201");
        Department ai = school.addDepartment("人工智能系", "B3-305");

        Instructor zhang = cs.addInstructor("张老师", "教授");
        Instructor li = cs.addInstructor("李老师", "副教授");
        Instructor wang = ai.addInstructor("王老师", "讲师");

        Subject se = cs.addSubject("CS301", "软件工程", 3);
        Subject oop = cs.addSubject("CS201", "面向对象程序设计", 4);
        Subject ds = ai.addSubject("AI101", "机器学习导论", 3);
        Subject arch = cs.addSubject("CS401", "软件体系结构", 3);

        zhang.teach(se);
        zhang.teach(oop);
        zhang.teach(ds);
        li.teach(se);
        wang.teach(ds);

        Student stu1 = school.addStudent("202410020103", "李怡瑶", "数据科学与大数据技术");
        stu1.enroll(se);
        stu1.enroll(oop);
        stu1.enroll(ds);

        // 各端多重性校验
        school.checkMultiplicity();
        for (Department d : school.getDepartments()) {
            d.checkMultiplicity();
            for (Instructor i : d.getInstructors()) {
                i.checkMultiplicity();
            }
        }
        for (Student s : school.getStudents()) {
            s.checkMultiplicity();
        }

        System.out.println(school);
        for (Department d : school.getDepartments()) {
            System.out.println("  " + d);
            for (Instructor i : d.getInstructors()) {
                System.out.println("    教师 " + i + " 教授 " + i.getSubjects());
            }
        }
        System.out.println("  学生 " + stu1 + " 选修 " + stu1.getSubjects());

        System.out.println("—— 越界检查：给教师排第 4 门课 ——");
        try {
            zhang.teach(arch);
        } catch (IllegalStateException e) {
            System.out.println("  约束生效：" + e.getMessage());
        }
    }
}
