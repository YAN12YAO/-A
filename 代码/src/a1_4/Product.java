package a1_4;

/** 商品。对应类图 Product：title、weight、description（另加 price 以支撑 getPriceForQuantity）。 */
public class Product {
    private String title;
    private double weight;
    private String description;
    private double price;

    public Product(String title, double weight, String description, double price) {
        this.title = title;
        this.weight = weight;
        this.description = description;
        this.price = price;
    }

    /**
     * 按数量计价：满 3 件 95 折，满 10 件 9 折，实现"团购/批发"语义。
     */
    public double getPriceForQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("数量必须大于 0");
        }
        double rate = 1.0;
        if (quantity >= 10) {
            rate = 0.90;
        } else if (quantity >= 3) {
            rate = 0.95;
        }
        return round2(price * quantity * rate);
    }

    public double getWeight() { return weight; }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public double getUnitPrice() { return price; }

    private static double round2(double v) {
        return Math.round(v * 100.0) / 100.0;
    }

    @Override
    public String toString() { return title + "（单价 " + price + " 元/" + weight + "kg）"; }
}
