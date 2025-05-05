package com.shreya.spring.service.impl;

import com.shreya.spring.model.DeliveryAgent;
import com.shreya.spring.repository.DeliveryAgentRepository;
import com.shreya.spring.service.DeliveryAgentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
@AllArgsConstructor

public class DeliveryAgentServiceImpl implements DeliveryAgentService {

    private static final Logger log = LoggerFactory.getLogger(DeliveryAgentServiceImpl.class);

    @Autowired
    private DeliveryAgentRepository deliveryAgentRepository;
    @Override
    public boolean addDeliveryAgent(DeliveryAgent deliveryAgent) throws SQLException {
        return deliveryAgentRepository.addDeliveryAgent(deliveryAgent);
    }

    @Override
    public boolean updateDeliveryAgent(DeliveryAgent deliveryAgent) throws SQLException {
        return deliveryAgentRepository.updateDeliveryAgent(deliveryAgent);
    }

    @Override
    public boolean deleteDeliveryAgent(int id) throws SQLException {
        return deliveryAgentRepository.deleteDeliveryAgent(id);
    }

    @Override
    public DeliveryAgent getDeliveryAgentById(int id) throws SQLException {
        return deliveryAgentRepository.findById(id);
    }

    @Override
    public List<DeliveryAgent> retrieveAllDeliveryAgents() throws SQLException {
        return deliveryAgentRepository.retrieveDeliveryAgents();
    }
}