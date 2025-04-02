package org.yhiago.accounts.Service.Impl;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.yhiago.accounts.Constants.AccountsConstants;
import org.yhiago.accounts.Dto.AccountsDto;
import org.yhiago.accounts.Dto.CustomerDto;
import org.yhiago.accounts.Exception.CustomerAlreadyExistsException;
import org.yhiago.accounts.Mapper.AccountsMapper;
import org.yhiago.accounts.Mapper.CustomerMapper;
import org.yhiago.accounts.Model.Accounts;
import org.yhiago.accounts.Model.Customer;
import org.yhiago.accounts.Repository.AccountRepository;
import org.yhiago.accounts.Repository.CustomerRepository;
import org.yhiago.accounts.Service.IAccountsService;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class AccoutServiceImpl implements IAccountsService {

    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;

    public AccoutServiceImpl(CustomerRepository customerRepository, AccountRepository accountRepository) {
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public void createAccount(CustomerDto dto) {
        Customer customer = CustomerMapper.mapToCustomer(dto, new Customer());
        Optional<Customer> existingCustomer = customerRepository.findByPhone(dto.getPhone());
        if (existingCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer already exists with this phone number" + dto.getPhone());
        }
        customer.setCreatedBy("anonymous");
        customer.setCreatedAt(LocalDateTime.now());
        Customer savedCustomer = customerRepository.save(customer);
        createNewAccount(savedCustomer);

    }

    @Override
    public CustomerDto getAccountDetails(String phone) {
        Customer customer = customerRepository.findByPhone(phone)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with this phone number" + phone));

        Accounts account = accountRepository.findByCustomerId(customer.getId())
                .orElseThrow(() -> new EntityNotFoundException("Account not found for customer with phone number" + phone));
        CustomerDto customerDto = new CustomerDto();
        CustomerMapper.mapToCustomerDto(customerDto, customer);
        customerDto.setAccounts(AccountsMapper.mapToAccountsDto(account,new AccountsDto()));
        return customerDto;
    }

    public CustomerDto UpdateCustomer(CustomerDto dto,Long id) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with this id" + id));

        var accounts = accountRepository.findByCustomerId(customer.getId())
                .orElseThrow(() -> new EntityNotFoundException("Account not found for customer with id" + id));

        Customer customerUpdate = CustomerMapper.mapToCustomer(dto, customer);

        if (dto.getAccounts() != null) {
            accounts = updateAccoutIfExists(dto, id, customer);
        }
        customerUpdate.setUpdatedAt(LocalDateTime.now());
        customerUpdate.setUpdatedBy("anonymous");
        Customer updatedCustomer = customerRepository.save(customerUpdate);
        var response =  CustomerMapper.mapToCustomerDto(dto, updatedCustomer);
        response.setAccounts(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));
        return CustomerMapper.mapToCustomerDto(dto, updatedCustomer);
    }

    private Accounts updateAccoutIfExists(CustomerDto dto, Long id, Customer customer) {
        Accounts account = accountRepository.findByCustomerId(customer.getId()).get();

       var accountUpdate = AccountsMapper.mapToAccounts(dto.getAccounts(), account);
       accountUpdate.setUpdatedAt(LocalDateTime.now());
       accountUpdate.setUpdatedBy("anonymous");
       return accountRepository.save(accountUpdate);

    }

    private void createNewAccount(Customer customer) {
        Accounts account = new Accounts();
        long randomNumber = 100000L + new Random().nextInt(9000000);
        account.setCustomerId(customer.getId());
        account.setAccountType(AccountsConstants.SAVINGS);
        account.setBranchAddress(AccountsConstants.ADDRESS);
        account.setAccountNumber(randomNumber);
        account.setCreatedAt(LocalDateTime.now());
        account.setCreatedBy("anonymous");
        accountRepository.save(account);
    }

    public void deleteAccount(Long id) {
        Accounts account = accountRepository.findByCustomerId(id)
                .orElseThrow(() -> new EntityNotFoundException("Account not found with this id" + id));
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with this id" + id));
        customerRepository.delete(customer);
        accountRepository.delete(account);
    }
}
