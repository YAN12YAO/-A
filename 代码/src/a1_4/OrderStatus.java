package a1_4;

/** 订单状态枚举，对应类图中的 «enumeration» OrderStatus。 */
public enum OrderStatus {
    CREATE("已创建"),
    PAID("已支付"),
    SHIPPING("配送中"),
    DELIVERED("已送达"),
    CANCEL("已取消");

    private final String cn;

    OrderStatus(String cn) { this.cn = cn; }

    public String getCn() { return cn; }

    @Override
    public String toString() { return name() + "(" + cn + ")"; }
}
