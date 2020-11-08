package hu.elte.clothingwebshop.controllers;

import hu.elte.clothingwebshop.entities.Product;
import hu.elte.clothingwebshop.entities.WsOrder;
import hu.elte.clothingwebshop.entities.User;
import hu.elte.clothingwebshop.repositories.OrderRepository;
import hu.elte.clothingwebshop.repositories.ProductRepository;
import hu.elte.clothingwebshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("")
    public ResponseEntity<Iterable<User>> getUsers() {
        Iterable<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Integer userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isPresent()) {
            return ResponseEntity.ok(optionalUser.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//    @PostMapping("")
//    public ResponseEntity<User> createUser(@RequestBody User user) {
//        User saveUser = userRepository.save(user);
//        return ResponseEntity.ok(saveUser);
//    }

    @PostMapping("")
    public ResponseEntity<User> register(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(User.Role.ROLE_USER);
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable Integer userId) {
        try {
            userRepository.deleteById(userId);
            return ResponseEntity.ok().build();
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{userId}/orders")
    public ResponseEntity<WsOrder> createOrder(@RequestBody WsOrder wsOrder, @PathVariable Integer userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(!optionalUser.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        User user = optionalUser.get();
        if(user.getWsOrders() == null) {
            user.setWsOrders(new ArrayList<WsOrder>());
        }
        user.getWsOrders().add(wsOrder);
        wsOrder.setUser(user);

        if(wsOrder.getProducts() != null) {
            List<Product> products = new ArrayList<>();
            for (Product product : wsOrder.getProducts()) {
                Optional<Product> optionalProduct = productRepository.findById(product.getId());
                if(optionalProduct.isPresent()) {
                    products.add(optionalProduct.get());
                    if(optionalProduct.get().getWsOrders() == null) {
                        optionalProduct.get().setWsOrders(new ArrayList<>());
                    }
                    optionalProduct.get().getWsOrders().add(wsOrder);
                }
            }
            wsOrder.setProducts(products);
        }

        WsOrder saveWsOrder = orderRepository.save(wsOrder);
        return ResponseEntity.ok(saveWsOrder);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> modifyUser(@RequestBody User modifiedUser, @PathVariable Integer userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(!optionalUser.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        User user = optionalUser.get();
        user.setPassword(modifiedUser.getPassword());
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }
}
