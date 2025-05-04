package com.shreya.spring.model;

import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartItem {
    private Long id;
    private Long customer_id;
    private Long menu_item_id;
    private int quantity;
}
