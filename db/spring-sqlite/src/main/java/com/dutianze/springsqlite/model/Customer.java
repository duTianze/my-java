package com.dutianze.springsqlite.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author dutianze
 * @date 2022/4/19
 */
@Data
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer customerId;

    public String firstName;

    public String lastName;

    public String company;

    public String address;

    public String city;

    public String state;

    public String country;

    public String postalCode;

    public String phone;

    public String fax;

    public String email;

    public Integer supportRepId;
}
