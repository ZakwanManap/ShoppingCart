package shop;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zakwanmanap on 14/2/2017.
 */

@RestController
public class ItemController {

    @ApiOperation(value = "createItem", nickname = "createItem")
    @RequestMapping(method = RequestMethod.GET, path="/createItem", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Item.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public Item createItem(@RequestParam String name, @RequestParam double price){
        Item item = new Item( name, price);
        ItemModel.itemList.add(item);
        return item;
    }

    @ApiOperation(value = "catalog", nickname = "catalog")
    @RequestMapping(method = RequestMethod.GET, path="/catalog", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Item.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public List<Item> listItems(){
        return ItemModel.itemList;
    }

    //for test purpose
    @ApiOperation(value = "generateCatalog", nickname = "generateCatalog")
    @RequestMapping(method = RequestMethod.GET, path="/generateCatalog", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public void generateCatalog(){
        Item item;
        item = new Item("ayam", 10.99 );
        ItemModel.itemList.add(item);
        item = new Item("itik", 16.99 );
        ItemModel.itemList.add(item);
        item = new Item("ikan", 5.85 );
        ItemModel.itemList.add(item);
        item = new Item("lembu", 16.50 );
        ItemModel.itemList.add(item);



    }
    public static Item getItem(int id){
        for (Item item: ItemModel.itemList){
            if(item.getId()==id){
                return item;
            }
        }
        return null;
    }
}
