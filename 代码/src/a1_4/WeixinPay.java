package a1_4;

/** 微信支付。 */
public class WeixinPay extends Payment {
    private String number;

    public WeixinPay(double amount, String number) {
        super(amount);
        this.number = number;
    }

    @Override
    public boolean pay() {
        System.out.println("  微信支付账号 " + number + " 支付 " + amount + " 元成功");
        return true;
    }

    @Override
    public String getMethodName() { return "微信支付 WeixinPay"; }
}
