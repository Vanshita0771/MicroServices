package com.lcwd.user.service.User.Service.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Rating {
    private String ratingId;
    private int rating;
    private String comment;
    private String userId;
    private String hotelId;
}
