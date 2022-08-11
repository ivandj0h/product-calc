package ivandjoh.online.calculator.service;

import ivandjoh.online.calculator.dao.Product;
import ivandjoh.online.calculator.dto.ProductDto;
import ivandjoh.online.calculator.dto.ProductDtoRequest;
import ivandjoh.online.calculator.dto.ProductDtoResponse;
import org.springframework.http.ResponseEntity;

public interface TransactionService {
    ResponseEntity<ProductDto> getAllProducts();

    ResponseEntity<Product> addNewProduct(Product product);

    ResponseEntity<Product> getProduct(Long id);

    ResponseEntity<ProductDtoResponse> postTransaction(Long id, ProductDtoRequest purchaseQuantity);
}
