package com.lcwd.Hotel.Service.HotelService.services.impl;


import com.lcwd.Hotel.Service.HotelService.entities.Hotel;
import com.lcwd.Hotel.Service.HotelService.exception.ResourceNotFoundException;
import com.lcwd.Hotel.Service.HotelService.repository.HotelRepository;
import com.lcwd.Hotel.Service.HotelService.services.HotelService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    @NonNull private final HotelRepository hotelRepository;


    @Override
    public Hotel createHotel(Hotel hotel) {
        String hotelId= UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotelById(String id) {
        return hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Hotel not found by id: "+id));
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }
}
