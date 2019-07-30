package org.microservices.webapi.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;

/**
 * Swagger is available on http://localhost:8100/swagger-ui.html
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket eDesignApi(SwaggerConfigProperties swaggerConfigProperties) {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo(swaggerConfigProperties))
                .enable(swaggerConfigProperties.getEnabled())
                .select().apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build().pathMapping("/")
                .directModelSubstitute(LocalDate.class, String.class)
                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(swaggerConfigProperties.getUseDefaultResponseMessages())
                .enableUrlTemplating(swaggerConfigProperties.getEnableUrlTemplating());
    }

    @Bean
    UiConfiguration uiConfig(SwaggerConfigProperties swaggerConfigProperties) {
        return UiConfigurationBuilder.builder()
                .deepLinking(swaggerConfigProperties.getDeepLinking())
                .displayOperationId(swaggerConfigProperties.getDisplayOperationId())
                .defaultModelsExpandDepth(swaggerConfigProperties.getDefaultModelsExpandDepth())
                .defaultModelExpandDepth(swaggerConfigProperties.getDefaultModelExpandDepth())
                .defaultModelRendering(ModelRendering.EXAMPLE)
                .displayRequestDuration(swaggerConfigProperties.getDisplayRequestDuration())
                .docExpansion(DocExpansion.NONE)
                .filter(swaggerConfigProperties.getFilter())
                .maxDisplayedTags(swaggerConfigProperties.getMaxDisplayedTags())
                .operationsSorter(OperationsSorter.ALPHA)
                .showExtensions(swaggerConfigProperties.getShowExtensions())
                .tagsSorter(TagsSorter.ALPHA)
                .supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
                .validatorUrl(null)
                .build();
    }

    private ApiInfo apiInfo(SwaggerConfigProperties swaggerConfigProperties) {
        return new ApiInfoBuilder()
                .title(swaggerConfigProperties.getTitle())
                .description(swaggerConfigProperties.getDescription())
                .version(swaggerConfigProperties.getApiVersion())
                .build();
    }
}