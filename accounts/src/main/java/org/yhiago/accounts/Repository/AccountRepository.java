package org.yhiago.accounts.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yhiago.accounts.Model.Accounts;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Accounts,Long> {

    Optional<Accounts> findByCustomerId(Long customerId);
}
