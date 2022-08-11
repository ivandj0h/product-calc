package ivandjoh.online.calculator.dao;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity @Getter @Setter
@ToString
@RequiredArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("product_name")
    @Column(name = "product_name")
    private String productName;
    @Column(name = "price")
    private Double price;
}
