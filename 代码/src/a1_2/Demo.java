package a1_2;

/** A1-2 测试：验证聚合与组合在生命周期上的差别。 */
public class Demo {
    public static void main(String[] args) {
        College college = new College("人工智能与计算机学院", "三峡大学欣苑");
        Building b1 = new Building("B1 教学楼", 800);
        Building b2 = new Building("B2 实验楼", 400);
        college.addBuilding(b1);
        college.addBuilding(b2);

        college.addCourse("CS101", "软件工程", 3, b1);
        college.addCourse("CS102", "面向对象程序设计", 4, b2);
        System.out.println(college);
        for (Course c : college.getCourses()) {
            System.out.println("  " + c);
        }

        System.out.println("—— 学院撤销 ——");
        college.close();
    }
}
