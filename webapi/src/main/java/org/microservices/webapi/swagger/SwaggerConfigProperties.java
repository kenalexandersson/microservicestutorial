package org.microservices.webapi.swagger;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@ConfigurationProperties(prefix = "swagger") // the actual props will be read from webapi.yml in the config-server project
@Configuration("swaggerConfigProperties")
public class SwaggerConfigProperties {

    private String apiVersion;
    private Boolean enabled = false;
    private String title;
    private String description;
    private Boolean useDefaultResponseMessages;
    private Boolean enableUrlTemplating;
    private Boolean deepLinking;
    private Integer defaultModelsExpandDepth;
    private Integer defaultModelExpandDepth;
    private Boolean displayOperationId;
    private Boolean displayRequestDuration;
    private Boolean filter;
    private Integer maxDisplayedTags;
    private Boolean showExtensions;
}
