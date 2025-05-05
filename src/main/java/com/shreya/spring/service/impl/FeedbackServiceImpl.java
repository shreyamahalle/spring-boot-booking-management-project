package com.shreya.spring.service.impl;

import com.shreya.spring.model.Feedback;
import com.shreya.spring.repository.FeedbackRepository;
import com.shreya.spring.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public boolean addFeedback(Feedback feedback) throws SQLException {
        return feedbackRepository.addFeedback(feedback);
    }

    @Override
    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.retrieveFeedbacks();
    }

    @Override
    public Optional<Feedback> getFeedbackById(Long id) {
        return feedbackRepository.findById(id);
    }

    @Override
    public boolean deleteFeedback(Long id) {
        return feedbackRepository.deleteFeedback(id);
    }

    @Override
    public boolean updateFeedback(Feedback feedback) {
        return feedbackRepository.updateFeedback(feedback);
    }
}
