package shop;

/**
 * Created by zakwanmanap on 14/2/2017.
 */
public class Item {
    private static int unique_id = 0;
    private int id;
    private String name;
    private double price;

    Item(String name, double price) {
        this.id = unique_id++;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
