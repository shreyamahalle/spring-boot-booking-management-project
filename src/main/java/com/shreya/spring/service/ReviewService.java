package com.shreya.spring.service;

import com.shreya.spring.model.Review;
import com.shreya.spring.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public boolean addReview(Review review) throws SQLException {
        return reviewRepository.addReview(review);
    }

    public List<Review> getAllReviews() throws SQLException {
        return reviewRepository.retrieveReviews();
    }

    public Review getReviewById(Long id) {
        return reviewRepository.findById(id);  // Calling the repository's findById method
    }

    public boolean updateReview(Review review) {
        return reviewRepository.updateReview(review);
    }

    public boolean deleteReview(Long id) {
        return reviewRepository.deleteReview(id);
    }
}
