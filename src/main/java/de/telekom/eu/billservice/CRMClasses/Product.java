package de.telekom.eu.billservice.CRMClasses;

import lombok.Data;

@Data
public class Product {
    private int id;
    private String productName;
    private ProductType productType;
    private double price;

    public enum ProductType {
        INTERNET, TV, TELEPHONY
    }
}
