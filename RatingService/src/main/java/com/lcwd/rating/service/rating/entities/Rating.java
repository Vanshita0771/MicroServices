package com.lcwd.rating.service.rating.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user_rating")
public class Rating{
    @Id
    private String ratingId;
    private int rating;
    private String comment;
    private String userId;
    private String hotelId;
    @Transient
    private Hotel hotel;
}
