package com.sd4.L11.entitys;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "roles")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    //The inverse side of the many-to-many relationship with the Customer entity
    //Each Role can be associated with multiple Customers, and each Customer can have multiple Roles.
    //Using a SEt is imortat here so that each customer is unique within the collection, preventing duplicates.
    @ManyToMany(mappedBy = "roles")
    private Set<Customer> customers;

}