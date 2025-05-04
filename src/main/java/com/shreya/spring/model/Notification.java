package com.shreya.spring.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Notification {
    private Long id;
    private Long customerId;
    private String message;
    private boolean isRead;
    private String timestamp;
}
