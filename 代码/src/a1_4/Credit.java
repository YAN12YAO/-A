package a1_4;

import java.time.LocalDate;

/** 信用卡支付。 */
public class Credit extends Payment {
    private String number;
    private String type;
    private LocalDate expireDate;

    public Credit(double amount, String number, String type, LocalDate expireDate) {
        super(amount);
        this.number = number;
        this.type = type;
        this.expireDate = expireDate;
    }

    @Override
    public boolean pay() {
        if (expireDate.isBefore(LocalDate.now())) {
            System.out.println("  信用卡 " + mask(number) + " 已过期，支付失败");
            return false;
        }
        System.out.println("  信用卡 " + type + " " + mask(number) + " 扣款 " + amount + " 元成功");
        return true;
    }

    @Override
    public String getMethodName() { return "信用卡 Credit"; }

    private static String mask(String no) {
        return no.length() <= 4 ? no : "****" + no.substring(no.length() - 4);
    }
}
