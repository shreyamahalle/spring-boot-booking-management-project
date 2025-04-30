package com.shreya.spring.service;

import com.shreya.spring.model.DeliveryAgent;
import com.shreya.spring.repository.DeliveryAgentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryAgentService {

    @Autowired
    private final DeliveryAgentRepository deliveryAgentRepository;

    public boolean addDeliveryAgent(DeliveryAgent deliveryAgent) throws SQLException {
        return deliveryAgentRepository.addDeliveryAgent(deliveryAgent);
    }

    public boolean updateDeliveryAgent(DeliveryAgent deliveryAgent) throws SQLException {
        return deliveryAgentRepository.updateDeliveryAgent(deliveryAgent);
    }

    public boolean deleteDeliveryAgent(int id) throws SQLException {
        return deliveryAgentRepository.deleteDeliveryAgent(id);
    }

    public DeliveryAgent getDeliveryAgentById(int id) throws SQLException {
        return deliveryAgentRepository.findById(id);
    }


    public List<DeliveryAgent> retrieveAllDeliveryAgents() throws SQLException {
        return deliveryAgentRepository.retrieveDeliveryAgents();
    }
}
