package com.pluralsight.fastpassservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

    List<Cart> customers;

    public CartController() {

        customers = new ArrayList<Cart>();
        customers.add(new Cart("800", "Omar Zidan", "555-123-4567", 19.50f));
        customers.add(new Cart("801", "Maggie Bell", "555-321-7654", 11.25f));
        customers.add(new Cart("802", "Tiffany Wallace", "555-987-6543", 35.05f));

    }
    
    @RequestMapping(path="/fastpass", params={"fastpassid"})
    public Cart getFastPassById(@RequestParam String fastpassid) {
        System.out.println("fast pass retrieved for " + fastpassid);
        return customers.stream().filter(customer -> fastpassid.equals(customer.getFastPassId())).findAny().orElse(new Cart());
    }
}
