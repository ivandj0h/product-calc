package ivandjoh.online.calculator.controller;

import ivandjoh.online.calculator.dao.Product;
import ivandjoh.online.calculator.dto.ProductDto;
import ivandjoh.online.calculator.dto.ProductDtoRequest;
import ivandjoh.online.calculator.dto.ProductDtoResponse;
import ivandjoh.online.calculator.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping("/products")
    public ResponseEntity<ProductDto> getProducts() {
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

    @PostMapping(value = "/product/transaction/{id}", consumes = "application/json")
    public ResponseEntity<ProductDtoResponse> postTransaction(
            @RequestBody ProductDtoRequest purchaseQuantity,
            @PathVariable Long id
    ) {
        return transactionService.postTransaction(id, purchaseQuantity);
    }
}
