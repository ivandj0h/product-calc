package ivandjoh.online.calculator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({"product_id","product_name", "product_price"})
public class ProductDto {
    @JsonProperty("product_id")
    private Long id;
    @JsonProperty("product_name")
    private String productName;
    @JsonProperty("carton_price")
    private Double price;
}
