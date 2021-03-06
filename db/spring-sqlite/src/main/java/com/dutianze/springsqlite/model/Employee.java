package com.dutianze.springsqlite.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author dutianze
 * @date 2022/4/19
 */
@Data
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer employeeId;

    public String lastName;

    public String firstName;

    public String title;

    public Integer reportsTo;

    public String birthDate;

    public String hireDate;

    public String address;

    public String city;

    public String state;

    public String country;

    public String postalCode;

    public String phone;

    public String fax;

    public String email;
}
