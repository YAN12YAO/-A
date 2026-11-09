package a1_1;

/** A1-1 测试：构造三代优良品质的马并输出年龄与父母信息。 */
public class Demo {
    public static void main(String[] args) {
        Thoroughbred grandFather = new Thoroughbred(null, null, 2005);
        Thoroughbred grandMother = new Thoroughbred(null, null, 2006);
        Thoroughbred father = new Thoroughbred(grandMother, grandFather, 2012);
        Thoroughbred mother = new Thoroughbred(null, null, 2013);
        Thoroughbred foal = new Thoroughbred(mother, father, 2022);

        System.out.println("祖父 " + grandFather);
        System.out.println("父马 " + father);
        System.out.println("幼马 " + foal);
        System.out.println("幼马当前年龄：" + foal.getCurrentAge() + " 岁");
        System.out.println("幼马之父的出生年份：" + foal.getFather());
        System.out.println("幼马之母的出生年份：" + foal.getMother());
    }
}
