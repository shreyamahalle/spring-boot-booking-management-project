package com.shreya.spring.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Restaurant {
    private int registerNo;
    private String name;
    private String City;
    private String Area;
}