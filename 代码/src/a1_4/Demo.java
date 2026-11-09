package a1_4;

import java.time.LocalDate;

/** A1-4 测试：完整走一遍"下单 → 计价 → 支付 → 发货 → 送达"的流程。 */
public class Demo {
    public static void main(String[] args) {
        Customer customer = new Customer("李怡瑶", "13800000000", "湖北省宜昌市三峡大学");
        System.out.println("客户：" + customer);

        Product book = new Product("《UML 基础指南》", 0.6, "UML 建模入门读物", 59.0);
        Product pen = new Product("中性笔", 0.02, "0.5mm 黑色", 3.5);

        Order order = customer.placeOrder();
        order.addDetail(book, 2);
        order.addDetail(pen, 12);

        System.out.println("订单：" + order);
        for (OrderDetail d : order.getDetails()) {
            System.out.println("  " + d + "，重量 " + d.calculateWeight() + " kg");
        }

        System.out.println("—— 支付方式一：信用卡（已过期）——");
        Payment expired = new Credit(order.calculateTotal(), "6222020200112233", "VISA",
                LocalDate.now().minusYears(1));
        System.out.println("  支付结果：" + order.pay(expired) + "，订单状态：" + order.getStatus());

        System.out.println("—— 支付方式二：微信支付 ——");
        Payment wx = new WeixinPay(order.calculateTotal(), "wx_liyiyao");
        System.out.println("  " + wx);
        boolean ok = order.pay(wx);
        System.out.println("  支付结果：" + ok + "，订单状态：" + order.getStatus());

        order.ship();
        System.out.println("  发货后状态：" + order.getStatus());
        order.deliver();
        System.out.println("  送达后状态：" + order.getStatus());

        System.out.println("—— 状态机保护：已送达订单不能取消 ——");
        try {
            order.cancel();
        } catch (IllegalStateException e) {
            System.out.println("  约束生效：" + e.getMessage());
        }

        System.out.println("—— 现金支付找零示例 ——");
        new Cash(88.5, 100).pay();
        System.out.println("—— 在线转账示例 ——");
        new WireTransfer(320.0, "102100099996", "中国工商银行").pay();
        System.out.println("—— 支付宝示例 ——");
        new AliPay(66.0, "liyiyao@alipay.com").pay();
    }
}
