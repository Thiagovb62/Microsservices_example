package org.yhiago.accounts.Controller;

import jakarta.persistence.GeneratedValue;
import jakarta.transaction.Transactional;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yhiago.accounts.Constants.AccountsConstants;
import org.yhiago.accounts.Dto.CustomerDto;
import org.yhiago.accounts.Dto.ResponseDto;
import org.yhiago.accounts.Mapper.CustomerMapper;
import org.yhiago.accounts.Service.IAccountsService;

@RestController
@RequestMapping(path = "/api/v1/accounts",
        consumes = "application/json",
        produces = "application/json")
public class AccountController {

    private final IAccountsService accountsService;

    public AccountController(IAccountsService accountsService) {
        this.accountsService = accountsService;
    }

    @GetMapping(path = "/getAccountDetails")
    public ResponseEntity<CustomerDto> getAccountDetails(@RequestParam String phone){
        CustomerDto customerDto = accountsService.getAccountDetails(phone);
        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto dto) {

        accountsService.createAccount(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(
                AccountsConstants.STATUS_201,
                AccountsConstants.MESSAGE_201));

    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<CustomerDto> updateAccount(@RequestBody CustomerDto dto, @PathVariable Long id) {
       CustomerDto customerDto = accountsService.UpdateCustomer(dto, id);
        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }

    @DeleteMapping(path = "/delete/{id}")
    @Transactional
    public ResponseEntity deleteAccount(@PathVariable Long id) {
        accountsService.deleteAccount(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ResponseDto(
                AccountsConstants.STATUS_200,
                AccountsConstants.MESSAGE_20));
    }



}
