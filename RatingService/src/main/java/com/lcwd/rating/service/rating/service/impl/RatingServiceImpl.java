package com.lcwd.rating.service.rating.service.impl;

import com.lcwd.rating.service.rating.entities.Hotel;
import com.lcwd.rating.service.rating.entities.Rating;
import com.lcwd.rating.service.rating.repository.RatingRepository;
import com.lcwd.rating.service.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired private RatingRepository ratingRepository;
    @Autowired private RestTemplate restTemplate;

    @Override
    public Rating createRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingsByHotelId(String hotelId) {
        List<Rating> ratingList=ratingRepository.findByHotelId(hotelId);
        for(Rating rating:ratingList){
            rating.setHotel(restTemplate.getForObject("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class));
        }
        return ratingList;
    }

    @Override
    public List<Rating> getRatingsByUserId(String userId) {
        List<Rating> ratingList=ratingRepository.findByUserId(userId);
        for(Rating rating:ratingList){
            rating.setHotel(restTemplate.getForObject("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class));
        }
        return ratingList;
    }
}
