package ivandjoh.online.calculator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductDtoRequest {
    @JsonProperty("purchase_quantity")
    private int purchaseQuantity;
}
