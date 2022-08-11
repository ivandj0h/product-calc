package ivandjoh.online.calculator.service.impl;

import ivandjoh.online.calculator.dao.Product;
import ivandjoh.online.calculator.repository.ProductRepository;
import ivandjoh.online.calculator.service.TransactionService;
import ivandjoh.online.calculator.utils.CalcUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public ResponseEntity<List<Product>> getAllProducts() {

        try {
            List<Product> products = productRepository.findAll();
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<Product> addNewProduct(Product product) {
        try {
            Product newProduct = productRepository.save(product);
            return ResponseEntity.ok(newProduct);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<Product> getProduct(Long id) {
        try {
            Product product = productRepository.findById(id).get();
            return ResponseEntity.ok(product);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<?> postTransaction(Long id, int purchaseQuantity) {

        CalcUtils calcUtils = new CalcUtils();
        double amount = calcUtils.calculateAmount(id, purchaseQuantity);

        return amount == Double.parseDouble("Invalid purchase quantity") ? ResponseEntity.badRequest().build() : ResponseEntity.ok(amount);
    }
}
