package com.shreya.spring.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Order {
    private int id;
    private String type;
    private String note;
    private String paymentMethod;

}
