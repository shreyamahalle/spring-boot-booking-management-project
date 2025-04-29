package com.shreya.spring.controller;

import com.shreya.spring.model.Review;
import com.shreya.spring.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/reviewManagement")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/review")
    public boolean addReview(@RequestBody Review review) throws SQLException {
        return reviewService.addReview(review);
    }

    @GetMapping("/review")
    public List<Review> getAllReviews() throws SQLException {
        return reviewService.getAllReviews();
    }

    @GetMapping("/review/{id}")
    public Review getReviewById(@PathVariable Long id) {
        return reviewService.getReviewById(id);
    }

    @PutMapping("/review/{id}")
    public boolean updateReview(@PathVariable Long id, @RequestBody Review review) {
        review.setId(id);
        return reviewService.updateReview(review);
    }

    @DeleteMapping("/review/{id}")
    public boolean deleteReview(@PathVariable Long id) {
        return reviewService.deleteReview(id);
    }
}
