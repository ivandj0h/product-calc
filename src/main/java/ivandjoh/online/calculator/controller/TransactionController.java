package ivandjoh.online.calculator.controller;

import ivandjoh.online.calculator.dao.Product;
import ivandjoh.online.calculator.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        return transactionService.getAllProducts();
    }

    @PostMapping("/product")
    public ResponseEntity<Product> addNewProduct(@RequestBody Product product) {
        return transactionService.addNewProduct(product);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        return transactionService.getProduct(id);
    }

    @PostMapping("/products/transaction")
    public ResponseEntity<?> postTransaction(
            @RequestBody int purchaseQuantity,
            @RequestParam Long id
    ) {
        return transactionService.postTransaction(id, purchaseQuantity);
    }
}
