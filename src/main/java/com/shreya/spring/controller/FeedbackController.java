package com.shreya.spring.controller;

import com.shreya.spring.model.Feedback;
import com.shreya.spring.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/feedback")
    public boolean addFeedback(@RequestBody Feedback feedback) throws SQLException {
        return feedbackService.addFeedback(feedback);
    }

    @GetMapping("/feedback")
    public List<Feedback> getAllFeedbacks() {
        return feedbackService.getAllFeedbacks();
    }

    @GetMapping("/feedback/{id}")
    public Optional<Feedback> getFeedbackById(@PathVariable Long id) {
        return feedbackService.getFeedbackById(id);
    }

    @DeleteMapping("/feedback/{id}")
    public boolean deleteFeedback(@PathVariable Long id) {
       return feedbackService.deleteFeedback(id);
    }

    @PutMapping("/feedback")
    public boolean updateFeedback(@RequestBody Feedback feedback) {
       return feedbackService.updateFeedback(feedback);
    }
}
