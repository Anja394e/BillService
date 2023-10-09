package de.telekom.eu.billservice.Bill;

import de.telekom.eu.billservice.CRMClasses.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BillService {

    private final ApiClient apiClient;

    public BillService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public Bill makeBill(int customerId) {

        Bill bill = new Bill();

        double resultBill = 0;
        Customer customer = apiClient.readCustomerById(customerId);

        if (customer == null){
            String errorNoCustomer = "Error: Customer with ID " + customerId +" does not Exist.";
            System.out.println(errorNoCustomer);
            return bill;
        }

        Set<Product> products = customer.getProducts();
        for (Product product : products){
            switch (product.getProductType()) {
                case TV -> {
                    product.setPrice(16.00);
                    resultBill += product.getPrice();
                }
                case INTERNET -> {
                    product.setPrice(28.00);
                    resultBill += product.getPrice();
                }
                case TELEPHONY -> {
                    List<Call> calls = customer.getCalls();
                    product.setPrice(0);
                    for (int i = 0; i <= calls.size() / 2; i += 2) {
                        Date start = calls.get(i).getTimestamp();
                        Date end = calls.get(i + 1).getTimestamp();
                        double minutes = end.getMinutes() - start.getMinutes();
                        product.setPrice(product.getPrice() + 0.1 * minutes + 0.19);

                    }
                    resultBill += product.getPrice();
                }
            }
        }
        bill.setProducts(customer.getProducts());
        bill.setFirstName(customer.getFirstName());
        bill.setLastName(customer.getLastName());
        bill.setTotalPrice(resultBill);
        bill.setCalls(customer.getCalls());

        return bill;
    }
}
