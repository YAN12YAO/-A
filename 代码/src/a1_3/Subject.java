package a1_3;

/** 课程（Subject）。 */
public class Subject {
    private String code;
    private String title;
    private int credit;

    public Subject(String code, String title, int credit) {
        this.code = code;
        this.title = title;
        this.credit = credit;
    }

    public String getCode() { return code; }
    public String getTitle() { return title; }
    public int getCredit() { return credit; }

    @Override
    public String toString() { return code + " " + title; }
}
