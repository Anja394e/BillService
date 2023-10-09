package de.telekom.eu.billservice.Bill;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/customers")
public class BillController {

    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping(path = "{customerId}/bill")
    public Bill getBill(@PathVariable("customerId") int customerId){
        return billService.makeBill(customerId);
    }

}
