package com.shreya.spring.controller;

import com.shreya.spring.model.Feedback;
import com.shreya.spring.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping
    public String addFeedback(@RequestBody Feedback feedback) throws SQLException {
        boolean isAdded = feedbackService.addFeedback(feedback);
        return isAdded ? "Feedback added successfully." : "Failed to add feedback.";
    }

    @GetMapping
    public List<Feedback> getAllFeedbacks() {
        return feedbackService.getAllFeedbacks();
    }

    @GetMapping("/{id}")
    public Optional<Feedback> getFeedbackById(@PathVariable Long id) {
        return feedbackService.getFeedbackById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteFeedback(@PathVariable Long id) {
        boolean isDeleted = feedbackService.deleteFeedback(id);
        return isDeleted ? "Feedback deleted successfully." : "Failed to delete feedback.";
    }

    @PutMapping
    public String updateFeedback(@RequestBody Feedback feedback) {
        boolean isUpdated = feedbackService.updateFeedback(feedback);
        return isUpdated ? "Feedback updated successfully." : "Failed to update feedback.";
    }
}
