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
    public String addDeliveryAgent(@RequestBody DeliveryAgent deliveryAgent) throws SQLException {
        boolean success = deliveryAgentService.addDeliveryAgent(deliveryAgent);
        return success ? "Delivery Agent added successfully" : "Failed to add Delivery Agent";
    }

    @PutMapping("/deliveryAgent/{id}")
    public String updateDeliveryAgent(@PathVariable int id, @RequestBody DeliveryAgent deliveryAgent) throws SQLException {
        deliveryAgent.setId(id);
        deliveryAgentService.updateDeliveryAgent(deliveryAgent);
        return "DeliveryAgent updated successfully!";
    }

    @DeleteMapping("/deliveryAgent/{id}")
    public String deleteDeliveryAgent(@PathVariable int id) throws SQLException {
        boolean success = deliveryAgentService.deleteDeliveryAgent(id);
        return success ? "Delivery Agent deleted successfully" : "Failed to delete Delivery Agent";
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