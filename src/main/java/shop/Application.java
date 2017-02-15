package shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by zakwanmanap on 14/2/2017.
 */

@SpringBootApplication
@EnableSwagger2
@ComponentScan("shop")
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("all")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/*.*"))
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Shopping Cart Web Service Mini Project")
                .description("Shopping Cart Web Service Mini Project")
                .contact("Zakwan")
                .version("1.0")
                .build();
    }
}
