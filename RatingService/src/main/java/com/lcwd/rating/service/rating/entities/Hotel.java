package com.lcwd.rating.service.rating.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Hotel {
    private String id;
    private String name;
    private String address;
    private String about;
}
