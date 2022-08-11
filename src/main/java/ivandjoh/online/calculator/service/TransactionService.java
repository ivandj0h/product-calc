package ivandjoh.online.calculator.service;

import ivandjoh.online.calculator.dao.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TransactionService {
    ResponseEntity<List<Product>> getAllProducts();
}
