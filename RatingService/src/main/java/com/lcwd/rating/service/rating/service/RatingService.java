package com.lcwd.rating.service.rating.service;

import com.lcwd.rating.service.rating.entities.Rating;

import java.util.List;

public interface RatingService {
    Rating createRating(Rating rating);
    List<Rating> getRatings();
    List<Rating> getRatingsByHotelId(String hotelId);
    List<Rating> getRatingsByUserId(String userId);
}
