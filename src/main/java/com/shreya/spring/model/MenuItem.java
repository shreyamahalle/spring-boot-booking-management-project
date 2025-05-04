package com.shreya.spring.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuItem {
    private Long id;
    private String name;
    private String description;
    private double price;
    private Long restaurantId;
}
