package ivandjoh.online.calculator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({
        "product_id",
        "product_name",
        "carton_price",
        "single_unit_price",
        "purchase_quantity",
        "total_price"
})
public class ProductDtoPerCartonResponse {
    @JsonProperty("product_id")
    private Long id;
    @JsonProperty("product_name")
    private String productName;
    @JsonProperty("carton_price")
    private Double price;
    @JsonProperty("purchase_quantity")
    private int purchaseQuantity;
    @JsonProperty("total_price")
    private Double totalPrice;
}
