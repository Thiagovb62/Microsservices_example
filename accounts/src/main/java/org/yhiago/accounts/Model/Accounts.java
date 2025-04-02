package org.yhiago.accounts.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
public class Accounts extends BaseEntity {

    @Id
    @Column(name = "account_id")
    private Long accountNumber;

    private Long customerId;


    private String accountType;

    private String branchAddress;


    public Accounts() {
    }



}
