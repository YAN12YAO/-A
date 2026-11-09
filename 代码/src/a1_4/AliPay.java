package a1_4;

/** 支付宝。 */
public class AliPay extends Payment {
    private String number;

    public AliPay(double amount, String number) {
        super(amount);
        this.number = number;
    }

    @Override
    public boolean pay() {
        System.out.println("  支付宝账号 " + number + " 支付 " + amount + " 元成功");
        return true;
    }

    @Override
    public String getMethodName() { return "支付宝 AliPay"; }
}
