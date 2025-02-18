package com.lcwd.user.service.User.Service.services.impl;

import com.lcwd.user.service.User.Service.entities.Rating;
import com.lcwd.user.service.User.Service.entities.User;
import com.lcwd.user.service.User.Service.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.User.Service.repository.UserRepository;
import com.lcwd.user.service.User.Service.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @NonNull
    public final UserRepository userRepository;
    @NonNull
    public final RestTemplate restTemplate;

    @Override
    public User createUser(User user) {
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
  // @CircuitBreaker(name = "ratingServiceBreaker", fallbackMethod = "fallbackRatings")
  //  @Retry(name = "ratingService",fallbackMethod = "fallbackRatings")
    @RateLimiter(name = "ratingServiceRateLimiter", fallbackMethod = "fallbackRatings")
    public User getUserById(String userId) {

        User user= userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));

        ArrayList<Rating>  ratings = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+userId, ArrayList.class);
        user.setRatings(ratings);

        return user;
    }

    public User fallbackRatings(String userId, Throwable t) {

        User user = User.builder()
                .name("Dummy User")
                .email("dummy@gmail.com")
                .about("Dummy user").build();

        // Returning user with empty ratings
        user.setRatings(new ArrayList<>());
        return user;
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String userId) {

    }
}
