package org.yhiago.accounts.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.yhiago.accounts.Model.Customer;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {


    @Query("SELECT c FROM Customer c WHERE c.phone like :phone")
    Optional<Customer> findByPhone(String phone);
}
