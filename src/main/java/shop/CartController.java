package shop;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zakwanmanap on 14/2/2017.
 */

@RestController
public class CartController {

    @ApiOperation(value = "addToCart", nickname = "addToCart")
    @RequestMapping(method = RequestMethod.GET, path="/addToCart", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public void addToCart(@RequestParam int id, @RequestParam int quantity){
        Item item = ItemController.getItem(id);
        if(item!=null){
            Cart.addItem(item, quantity);
        }

    }

    @ApiOperation(value = "removeFromCart", nickname = "removeFromCart")
    @RequestMapping(method = RequestMethod.GET, path="/removeFromCart", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public void removeFromCart(@RequestParam int id){
        Item item = ItemController.getItem(id);
        if(item!=null){
            Cart.addItem(item, 0);
        }

    }

    @ApiOperation(value = "getTotalPrice", nickname = "getTotalPrice")
    @RequestMapping(method = RequestMethod.GET, path="/getTotalPrice", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Double.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public double getTotalPrice(){
        return Cart.getTotalPrice();
    }

    @ApiOperation(value = "viewCart", nickname = "viewCart")
    @RequestMapping(method = RequestMethod.GET, path="/viewCart", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = CartItem.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public List<CartItem> viewCart(){
        return Cart.getCart();
    }

}
