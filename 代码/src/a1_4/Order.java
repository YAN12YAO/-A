package a1_4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 订单。
 * 与 OrderDetail 是组合（订单 1 —— 订单详情 1..*），
 * 与 Payment 是 1 对 0..1 的关联，与 Customer 是 0..* 对 1 的关联。
 */
public class Order {
    private LocalDate createDate;
    private OrderStatus status;
    private Customer customer;
    private final List<OrderDetail> details = new ArrayList<>();
    private Payment payment;

    public Order(Customer customer) {
        this.customer = customer;
        this.createDate = LocalDate.now();
        this.status = OrderStatus.CREATE;
    }

    /** 组合语义：订单自己创建明细 */
    public OrderDetail addDetail(Product product, int quantity) {
        checkStatus(OrderStatus.CREATE);
        OrderDetail d = new OrderDetail(product, quantity);
        details.add(d);
        return d;
    }

    public double calculateTotal() {
        double total = 0;
        for (OrderDetail d : details) {
            total += d.calculateSubTotal();
        }
        return Math.round(total * 100.0) / 100.0;
    }

    public double calculateWeight() {
        double w = 0;
        for (OrderDetail d : details) {
            w += d.calculateWeight();
        }
        return Math.round(w * 100.0) / 100.0;
    }

    public boolean pay(Payment payment) {
        checkStatus(OrderStatus.CREATE);
        this.payment = payment;
        if (payment.getAmount() != calculateTotal()) {
            throw new IllegalArgumentException("支付金额 " + payment.getAmount()
                    + " 与订单总额 " + calculateTotal() + " 不一致");
        }
        if (payment.pay()) {
            status = OrderStatus.PAID;
            return true;
        }
        return false;
    }

    public void ship() {
        checkStatus(OrderStatus.PAID);
        status = OrderStatus.SHIPPING;
    }

    public void deliver() {
        checkStatus(OrderStatus.SHIPPING);
        status = OrderStatus.DELIVERED;
    }

    public void cancel() {
        if (status == OrderStatus.SHIPPING || status == OrderStatus.DELIVERED) {
            throw new IllegalStateException("已发货订单不能取消：" + status);
        }
        status = OrderStatus.CANCEL;
    }

    private void checkStatus(OrderStatus expected) {
        if (status != expected) {
            throw new IllegalStateException("当前状态 " + status + "，不能执行该操作（要求 " + expected + "）");
        }
    }

    public OrderStatus getStatus() { return status; }
    public LocalDate getCreateDate() { return createDate; }
    public List<OrderDetail> getDetails() { return details; }
    public Payment getPayment() { return payment; }

    @Override
    public String toString() {
        return "Order{" + createDate + ", " + status + ", 明细 " + details.size()
                + " 条, 总额 " + calculateTotal() + " 元, 总重 " + calculateWeight() + " kg}";
    }
}
