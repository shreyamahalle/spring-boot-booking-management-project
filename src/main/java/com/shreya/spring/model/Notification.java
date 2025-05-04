package com.shreya.spring.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Notification {
    private Long id;
    private Long customer_id;
    private String message;
    private boolean is_read;
    private String timestamp;
}
