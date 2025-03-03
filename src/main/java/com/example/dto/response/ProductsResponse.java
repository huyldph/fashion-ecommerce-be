package com.example.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductsResponse {
    private Integer productId;
    private String productName;
    private BigDecimal price;
    private String imageUrl;
    private String categoryName;
    private Integer purchases;
}
