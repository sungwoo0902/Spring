package kr.sungwoo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
    // http://localhost:8080/Ch10/v3/api-docs
    // http://localhost:8080/Ch10/swagger-ui/index.html
    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("Swagger API 제목")
                .version("1.0")
                .description("API에 대한 설명 부분");

        return new OpenAPI()
                .components(new Components())
                .info(info);
    }

}
