package shop;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zakwanmanap on 14/2/2017.
 */
public class Cart {

    private static double totalPrice = 0.0;
    private static List<CartItem> cart = new ArrayList<CartItem>();

    public static void addItem(Item item, int quantity){
        boolean found = false;
        for(CartItem cartItem: cart){
            if(item.getId()==cartItem.getItemId()){
                found = true;
                cartItem.setQuantity(quantity);
                break;
            }
        }
        if(!found){
            CartItem cartItem = new CartItem(item, quantity);
            cart.add(cartItem);
        }
        calculateTotalPrice();
    }

    private static void calculateTotalPrice(){
        totalPrice = 0;
        for(CartItem cartItem: cart){
            totalPrice += cartItem.getTotalPrice();
        }
    }

    public static double getTotalPrice(){
        return totalPrice;
    }

    @JsonProperty(required = true)
    @ApiModelProperty(notes = "The name of the user", required = true)
    public static List<CartItem> getCart(){
        return cart;
    }

}
