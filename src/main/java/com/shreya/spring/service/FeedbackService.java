package com.shreya.spring.service;

import com.shreya.spring.model.Feedback;
import com.shreya.spring.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public boolean addFeedback(Feedback feedback) throws SQLException {
        return feedbackRepository.addFeedback(feedback);
    }

    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.retrieveFeedbacks();
    }

    public Optional<Feedback> getFeedbackById(Long id) {
        return feedbackRepository.findById(id);
    }

    public boolean deleteFeedback(Long id) {
        return feedbackRepository.deleteFeedback(id);
    }

    public boolean updateFeedback(Feedback feedback) {
        return feedbackRepository.updateFeedback(feedback);
    }
}
