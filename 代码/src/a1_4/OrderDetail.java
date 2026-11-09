package a1_4;

/** 订单详情：一个商品 + 数量，负责计算小计与重量。 */
public class OrderDetail {
    private Product product;
    private int quantity;

    public OrderDetail(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /** 小计金额 = 商品按数量的计价 */
    public double calculateSubTotal() {
        return product.getPriceForQuantity(quantity);
    }

    /** 小计重量 = 单件重量 × 数量 */
    public double calculateWeight() {
        return product.getWeight() * quantity;
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }

    @Override
    public String toString() {
        return product.getTitle() + " × " + quantity + " = " + calculateSubTotal() + " 元";
    }
}
