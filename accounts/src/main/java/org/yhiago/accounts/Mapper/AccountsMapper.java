package org.yhiago.accounts.Mapper;

import org.yhiago.accounts.Dto.AccountsDto;
import org.yhiago.accounts.Model.Accounts;

public class AccountsMapper {

    public static AccountsDto mapToAccountsDto(Accounts accounts,AccountsDto accountsDto) {
        accountsDto.setAccountNumber(accounts.getAccountNumber());
        accountsDto.setAccountType(accounts.getAccountType());
        accountsDto.setBranchAddress(accounts.getBranchAddress());
        return accountsDto;

    }

    public static Accounts mapToAccounts(AccountsDto accountsDto,Accounts accounts) {
        accounts.setAccountNumber(accountsDto.getAccountNumber() != null ? accountsDto.getAccountNumber() : accounts.getAccountNumber());
        accounts.setAccountType(accountsDto.getAccountType() != null ? accountsDto.getAccountType() : accounts.getAccountType());
        accounts.setBranchAddress(accountsDto.getBranchAddress() != null ? accountsDto.getBranchAddress() : accounts.getBranchAddress());
        return accounts;
    }
}
