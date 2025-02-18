package com.lcwd.Hotel.Service.HotelService.repository;

import com.lcwd.Hotel.Service.HotelService.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, String> {
}