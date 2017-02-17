package shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by zakwanmanap on 16/2/2017.
 */

@Configuration
@EnableSwagger2
@ComponentScan("shop")
public class SwaggerConfig {

    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("all")
                .apiInfo(apiInfo())
                .select()
                /*.paths(regex("/*.*"))*/
                .paths(regex("^(?!/error).*$"))/*exclude error controller*/
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
