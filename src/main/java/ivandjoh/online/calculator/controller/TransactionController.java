package ivandjoh.online.calculator.controller;

import ivandjoh.online.calculator.dao.Product;
import ivandjoh.online.calculator.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        return transactionService.getAllProducts();
    }

    @PostMapping("/products/transaction")
    public String postTransaction() {
        return "transaction";
    }
}
