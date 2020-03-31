package com.chinono.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "sc.filter")
@Data
public class FilterProperties {
    private List<String> allowPaths;
}
