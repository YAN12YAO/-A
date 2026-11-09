package a1_4;

/** 在线转账（银行汇款）。 */
public class WireTransfer extends Payment {
    private String bankID;
    private String bankName;

    public WireTransfer(double amount, String bankID, String bankName) {
        super(amount);
        this.bankID = bankID;
        this.bankName = bankName;
    }

    @Override
    public boolean pay() {
        System.out.println("  通过 " + bankName + "（行号 " + bankID + "）转账 " + amount + " 元成功");
        return true;
    }

    @Override
    public String getMethodName() { return "在线转账 WireTransfer"; }
}
