package ivandjoh.online.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TransactionController {

    @GetMapping("/products")
    public String getProducts() {
        return "products";
    }

    @PostMapping("/products/transaction")
    public String postTransaction() {
        return "transaction";
    }
}
