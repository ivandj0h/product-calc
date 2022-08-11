package ivandjoh.online.calculator.utils;

import ivandjoh.online.calculator.dao.Product;
import ivandjoh.online.calculator.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalcUtils {

    @Autowired
    ProductRepository productRepository;

    public double calculateAmount(Long id, int purchaseQuantity) {
        try {
            Product product = productRepository.findById(id).get();
            if (purchaseQuantity == 1) {
                return product.getPrice() * 0.3;
            } else if (purchaseQuantity <= 2) {
                return product.getPrice() * 0.1;
            } else {
                return Double.parseDouble("Invalid purchase quantity");
            }
        } catch (Exception e) {
            return Double.parseDouble("Invalid purchase quantity");
        }
    }
}
