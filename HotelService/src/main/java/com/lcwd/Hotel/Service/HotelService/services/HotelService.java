package com.lcwd.Hotel.Service.HotelService.services;


import com.lcwd.Hotel.Service.HotelService.entities.Hotel;

import java.util.List;

public interface HotelService {
    Hotel createHotel(Hotel hotel);
    Hotel getHotelById(String id);
    List<Hotel> getAllHotels();
}
