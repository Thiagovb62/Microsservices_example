package com.eazybytes.loans.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties(prefix = "accounts")
public record AccountsQaDTO(
        String message, Map<String, String>contactDetail
) {
}
