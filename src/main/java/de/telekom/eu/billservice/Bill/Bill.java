package de.telekom.eu.billservice.Bill;

import de.telekom.eu.billservice.CRMClasses.Call;
import de.telekom.eu.billservice.CRMClasses.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter @Setter
public class Bill {
    private String firstName;
    private String lastName;
    private double totalPrice;
    private Set<Product> products;
    private List<Call> calls;
}
