package com.dolsoft.licenses.config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import lombok.Data;;
@Configuration
@ConfigurationProperties(prefix = "example")
@Data
public class ServerConfig {
    private String property;
}
