package de.telekom.eu.billservice.CRMClasses;

import lombok.Data;

import java.util.*;

@Data
public class Customer {
    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private Date creationDate;

    private Set<Product> products;
    private List<Call> calls;
}
