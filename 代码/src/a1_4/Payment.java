package a1_4;

/** 支付方式抽象类（斜体表示抽象）：持有金额 amount，子类实现具体的 pay()。 */
public abstract class Payment {
    /** 应付金额 */
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public double getAmount() { return amount; }

    /** 执行支付，成功返回 true */
    public abstract boolean pay();

    /** 支付方式的名称，便于输出 */
    public abstract String getMethodName();

    @Override
    public String toString() {
        return getMethodName() + "，金额 " + amount + " 元";
    }
}
