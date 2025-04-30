package com.shreya.spring.controller;

import com.shreya.spring.model.DeliveryAgent;
import com.shreya.spring.service.DeliveryAgentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("api/deliveryAgentManagement")
@RequiredArgsConstructor
public class DeliveryAgentController {

    @Autowired
    private final DeliveryAgentService deliveryAgentService;

    @PostMapping("/deliveryAgent")
    public boolean addDeliveryAgent(@RequestBody DeliveryAgent deliveryAgent) throws SQLException {
        return deliveryAgentService.addDeliveryAgent(deliveryAgent);
    }

    @PutMapping("/deliveryAgent/{id}")
    public boolean updateDeliveryAgent(@PathVariable int id, @RequestBody DeliveryAgent deliveryAgent) throws SQLException {
        deliveryAgent.setId(id);
        return deliveryAgentService.updateDeliveryAgent(deliveryAgent);
    }

    @DeleteMapping("/deliveryAgent/{id}")
    public boolean deleteDeliveryAgent(@PathVariable int id) throws SQLException {
        return deliveryAgentService.deleteDeliveryAgent(id);
    }

    @GetMapping("/deliveryAgent")
    public List<DeliveryAgent> getAllDeliveryAgents() throws SQLException {
        return deliveryAgentService.retrieveAllDeliveryAgents();
    }

    @GetMapping("/deliveryAgent/{id}")
    public DeliveryAgent getDeliveryAgentById(@PathVariable int id) throws SQLException {
        return deliveryAgentService.getDeliveryAgentById(id);
    }
}