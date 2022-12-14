package com.accenture.props;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "account-api")
@Configuration
public class AppProperties {

	private Map<String, String> messages = new HashMap();
}
