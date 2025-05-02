package com.shreya.spring.service;

import com.shreya.spring.model.DeliveryAgent;

import java.sql.SQLException;
import java.util.List;

public interface DeliveryAgentService {

    boolean addDeliveryAgent(DeliveryAgent deliveryAgent) throws SQLException;

    boolean updateDeliveryAgent(DeliveryAgent deliveryAgent) throws SQLException;

    boolean deleteDeliveryAgent(int id) throws SQLException;

    DeliveryAgent getDeliveryAgentById(int id) throws SQLException;

    List<DeliveryAgent> retrieveAllDeliveryAgents() throws SQLException;
}

//
//    public boolean addDeliveryAgent(DeliveryAgent deliveryAgent) throws SQLException {
//        return deliveryAgentRepository.addDeliveryAgent(deliveryAgent);
//    }
//    public boolean updateDeliveryAgent(DeliveryAgent deliveryAgent) throws SQLException {
//        return deliveryAgentRepository.updateDeliveryAgent(deliveryAgent);
//    }
//    public boolean deleteDeliveryAgent(int id) throws SQLException {
//        return deliveryAgentRepository.deleteDeliveryAgent(id);
//    }
//    public DeliveryAgent getDeliveryAgentById(int id) throws SQLException {
//        return deliveryAgentRepository.findById(id);
//    }
//    public List<DeliveryAgent> retrieveAllDeliveryAgents() throws SQLException {
//        return deliveryAgentRepository.retrieveDeliveryAgents();
//    }
//}
