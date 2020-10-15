package com.osc.orders;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class OrderController {
    @Autowired
    OrderRepository dao;

    @GetMapping("/user/order")
    public List<Order> getOrders() {
        List<Order> foundOrders = dao.findAll();
        return foundOrders;
    }

    @PostMapping("/user/order")
    public ResponseEntity<Order> postOrder(@RequestBody Order order) {
        // This saves to the osc database using repository.
        Order createOrder = dao.save(order);
        // Gives a response to include our status code
        return ResponseEntity.ok(createOrder);
    }

    @PutMapping("/user/order/{id}")
    public ResponseEntity<Order> putOrder(@PathVariable Integer id, @RequestBody Order order) {
        Order foundOrder = dao.findById(id).orElse(null);
        if (foundOrder == null) {
            return ResponseEntity.notFound().header("Message", "Order is not found").build();
        } else {
            if(order.getId() != null) {
                foundOrder.setId(order.getId());
            }
            dao.save(foundOrder);
        }

        return ResponseEntity.ok(foundOrder);
    }
@DeleteMapping("/user/order/{id}")
    public ResponseEntity<Order> deleteOrder(@PathVariable(value = "id") Integer id) {
        Order foundOrder = dao.findById(id).orElse(null);
        if (foundOrder == null) {
            return ResponseEntity.notFound().header("Message", "Order is not found").build();
        } else {
            dao.delete(foundOrder);
        }
        return ResponseEntity.ok().build();
    }

}
