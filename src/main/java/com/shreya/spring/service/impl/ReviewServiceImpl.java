package com.shreya.spring.service.impl;

import com.shreya.spring.model.Review;
import com.shreya.spring.repository.ReviewRepository;
import com.shreya.spring.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public boolean addReview(Review review) throws SQLException {
        return reviewRepository.addReview(review);
    }

    @Override
    public List<Review> getAllReviews() throws SQLException {
        return reviewRepository.retrieveReviews();
    }

    @Override
    public Review getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public boolean updateReview(Review review) {
        return reviewRepository.updateReview(review);
    }

    @Override
    public boolean deleteReview(Long id) {
        return reviewRepository.deleteReview(id);
    }
}
