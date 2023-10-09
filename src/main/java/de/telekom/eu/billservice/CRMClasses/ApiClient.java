package de.telekom.eu.billservice.CRMClasses;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "crm-api", url = "http://localhost:8080")
public interface ApiClient {

    @GetMapping(value = "/api/v1/customers/{customerId}")
    Customer readCustomerById(@PathVariable(value = "customerId") int customerId);

}
