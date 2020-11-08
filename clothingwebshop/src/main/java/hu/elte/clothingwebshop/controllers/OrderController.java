package hu.elte.clothingwebshop.controllers;

import hu.elte.clothingwebshop.entities.User;
import hu.elte.clothingwebshop.entities.WsOrder;
import hu.elte.clothingwebshop.repositories.OrderRepository;
import hu.elte.clothingwebshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

import javax.persistence.criteria.Order;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public ResponseEntity<Iterable<WsOrder>> getOrders() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<String> roles = auth.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        if (roles.contains("ROLE_ADMIN")) {
            return ResponseEntity.ok(orderRepository.findAll());
        }
        String username = auth.getName();
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get().getWsOrders());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<WsOrder> getOrder(@PathVariable Integer orderId) {
        Optional<WsOrder> optionalOrder = orderRepository.findById(orderId);
        if(optionalOrder.isPresent()) {
            return ResponseEntity.ok(optionalOrder.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<WsOrder> createOrder(@RequestBody WsOrder wsOrder) {
        WsOrder saveWsOrder = orderRepository.save(wsOrder);
        return ResponseEntity.ok(saveWsOrder);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Order> deleteOrder(@PathVariable Integer orderId) {
        try {
            orderRepository.deleteById(orderId);
            return ResponseEntity.ok().build();
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }



}
