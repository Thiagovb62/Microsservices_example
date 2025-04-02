package org.yhiago.accounts.Service;

import org.yhiago.accounts.Dto.CustomerDto;

public interface IAccountsService {

    void createAccount(CustomerDto dto);

    CustomerDto getAccountDetails(String phone);

    CustomerDto UpdateCustomer(CustomerDto dto,Long id);

     void deleteAccount(Long id);

}
