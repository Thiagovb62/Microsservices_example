package org.yhiago.accounts.Dto;

import lombok.Data;

@Data
public class CustomerDto {

    private String name;

    private String email;

    private String phone;

    private AccountsDto accounts;
}
