package org.yhiago.accounts.Mapper;

import org.yhiago.accounts.Dto.CustomerDto;
import org.yhiago.accounts.Model.Customer;

public class CustomerMapper {

    // Add your mapping methods here
    // For example, if you have a Customer entity and a CustomerDto, you can create methods to map between them

    public static CustomerDto mapToCustomerDto(CustomerDto customerDto,Customer customer) {
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setPhone(customer.getPhone());
        // Map other fields as needed
        return customerDto;
    }

    public static Customer mapToCustomer(CustomerDto customerDto,Customer customer) {
        customer.setName(customerDto.getName() != null ? customerDto.getName()  : customer.getName());
        customer.setEmail(customerDto.getEmail() != null ? customerDto.getEmail() : customer.getEmail());
        customer.setPhone( customerDto.getPhone() != null ? customerDto.getPhone() : customer.getPhone());
        // Map other fields as needed
        return customer;
    }
}
