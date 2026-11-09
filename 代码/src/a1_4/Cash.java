package a1_4;

/** 现金支付：cashTendered 为实收现金，amount 为应付金额，差额即找零。 */
public class Cash extends Payment {
    private double cashTendered;

    public Cash(double amount, double cashTendered) {
        super(amount);
        this.cashTendered = cashTendered;
    }

    @Override
    public boolean pay() {
        if (cashTendered < amount) {
            System.out.println("  现金 " + cashTendered + " 元不足，还差 " + round2(amount - cashTendered) + " 元");
            return false;
        }
        System.out.println("  收取现金 " + cashTendered + " 元，找零 " + round2(cashTendered - amount) + " 元");
        return true;
    }

    @Override
    public String getMethodName() { return "现金 Cash"; }

    private static double round2(double v) { return Math.round(v * 100.0) / 100.0; }
}
