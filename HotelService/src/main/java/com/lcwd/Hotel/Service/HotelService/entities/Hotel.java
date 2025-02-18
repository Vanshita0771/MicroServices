package com.lcwd.Hotel.Service.HotelService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "hotels")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Hotel {
    @Id
    private String id;
    private String name;
    private String address;
    private String about;
}
