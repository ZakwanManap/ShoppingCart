package shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by zakwanmanap on 14/2/2017.
 */

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        //Init catalog
        ItemController.generateCatalog();
        SpringApplication.run(Application.class, args);
    }
}
