package ivandjoh.online.calculator.service;

import ivandjoh.online.calculator.dao.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TransactionService {
    ResponseEntity<List<Product>> getAllProducts();

    ResponseEntity<Product> addNewProduct(Product product);

    ResponseEntity<Product> getProduct(Long id);

    ResponseEntity<?> postTransaction(Long id, int purchaseQuantity);
}
