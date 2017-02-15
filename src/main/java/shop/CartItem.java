package shop;

/**
 * Created by zakwanmanap on 14/2/2017.
 */
public class CartItem {

    private Item item;
    private int quantity;
    private double totalPrice;

    CartItem(Item item, int quantity){
        this.item = item;
        setQuantity(quantity);
    }

    public int getItemId(){
        return this.item.getId();
    }

    public void setQuantity(int quantity){
        if(quantity>0) {
            this.quantity = quantity;
            this.totalPrice = item.getPrice() * quantity;
        }
    }

    public int getQuantity(){
        return this.quantity;
    }

    public double getTotalPrice(){
        return this.totalPrice;
    }
}
