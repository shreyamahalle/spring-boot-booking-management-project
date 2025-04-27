package com.shreya.spring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class OrderStatus {
    private Long id;              // Unique identifier for the order status
    private String status;        // Status of the order (e.g., Pending, In Progress, Delivered)
    private String description;   // Description or notes related to the order status
}
