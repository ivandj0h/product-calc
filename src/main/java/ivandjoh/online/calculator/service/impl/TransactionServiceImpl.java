package ivandjoh.online.calculator.service.impl;

import ivandjoh.online.calculator.dao.Product;
import ivandjoh.online.calculator.dto.ProductDto;
import ivandjoh.online.calculator.dto.ProductDtoRequest;
import ivandjoh.online.calculator.dto.ProductDtoResponse;
import ivandjoh.online.calculator.repository.ProductRepository;
import ivandjoh.online.calculator.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public ResponseEntity<ProductDto> getAllProducts() {
        ProductDto response = new ProductDto();
        try {
            List<Product> products = productRepository.findAll();
                if (products.isEmpty()) {
                    return ResponseEntity.notFound().build();
                }
            response.setId(products.get(0).getId());
            response.setProductName(products.get(0).getProductName());
            response.setPrice(products.get(0).getPrice());

            return new ResponseEntity<>(response, org.springframework.http.HttpStatus.OK);
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
    public ResponseEntity<ProductDtoResponse> postTransaction(Long id, ProductDtoRequest purchaseQuantity) {

        DecimalFormat df = new DecimalFormat("#.##");
        ProductDtoResponse response = new ProductDtoResponse();
        try {
            Product product = productRepository.findById(id).get();
            if(purchaseQuantity.getPurchaseQuantity() == 1) {
                response.setId(product.getId());
                response.setProductName(product.getProductName());
                response.setPrice(product.getPrice());
                response.setSingleUnitPrice(Double.valueOf(df.format(product.getPrice() * 0.30 / 20)));

                return ResponseEntity.ok(response);
            }

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
