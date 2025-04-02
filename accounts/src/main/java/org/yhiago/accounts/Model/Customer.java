package org.yhiago.accounts.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "customer")
@Getter
@Setter
@ToString
public class Customer extends BaseEntity {

    private String name;
    private String email;
    private String phone;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Constructors, getters, and setters

    public Customer() {
    }

    public Customer(String name, String email, String phone, String address, String city, String state, String country, String postalCode) {
        this.name = name;
        this.email = email;
        this.phone = phone;

    }

}
