package a1_4;

import java.util.ArrayList;
import java.util.List;

/** 客户。1 个客户可有 0..* 个订单。 */
public class Customer {
    private String name;
    private String contact;
    private String deliveryAddress;
    private boolean active;
    private final List<Order> orders = new ArrayList<>();

    public Customer(String name, String contact, String deliveryAddress) {
        this.name = name;
        this.contact = contact;
        this.deliveryAddress = deliveryAddress;
        this.active = true;
    }

    /** 下单：客户与订单之间 1 对 0..* 关系的落地 */
    public Order placeOrder() {
        if (!active) {
            throw new IllegalStateException("账户未激活，不能下单");
        }
        Order o = new Order(this);
        orders.add(o);
        return o;
    }

    public void setActive(boolean active) { this.active = active; }

    public boolean isActive() { return active; }
    public String getName() { return name; }
    public List<Order> getOrders() { return orders; }

    @Override
    public String toString() {
        return name + "（" + contact + "，收货地址 " + deliveryAddress + "）";
    }
}
