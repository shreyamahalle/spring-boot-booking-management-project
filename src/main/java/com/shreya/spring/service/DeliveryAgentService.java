package com.shreya.spring.service;

import com.shreya.spring.model.DeliveryAgent;
import com.shreya.spring.repository.DeliveryAgentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryAgentService {

    private final DeliveryAgentRepository deliveryAgentRepository;

    public boolean addDeliveryAgent(DeliveryAgent deliveryAgent) throws SQLException {
        return deliveryAgentRepository.insertDeliveryAgent(deliveryAgent);
    }
    public boolean updateDeliveryAgent(DeliveryAgent deliveryAgent) throws SQLException {
        return deliveryAgentRepository.updateDeliveryAgent(deliveryAgent);
    }

    public boolean deleteDeliveryAgent(int id) throws SQLException {
        return deliveryAgentRepository.deleteDeliveryAgent(id);
    }

    public DeliveryAgent getDeliveryAgentByIdAndName(int id, String name) throws SQLException {
        return deliveryAgentRepository.retrieveDeliveryAgent(id, name);
    }

    public List<DeliveryAgent> retrieveAllDeliveryAgents() throws SQLException {
        return deliveryAgentRepository.retrieveDeliveryAgents();
    }
}
