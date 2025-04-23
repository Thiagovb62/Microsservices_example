package org.yhiago.accounts.Dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties(prefix = "accounts")
@Getter
@Setter
public class AccountsContactInfoDTO {
    private Map<Long, String> accountDetails;

    public Map<Long, String> getAccountDetails() {
        return accountDetails;
    }

    public void setAccountDetails(Map<Long, String> accountDetails) {
        this.accountDetails = accountDetails;
    }
}
