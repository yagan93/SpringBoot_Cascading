package com.example.cardinalities.domain.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderings")
public class OrderingController {

    private final OrderingService orderingService;

    @Autowired
    public OrderingController(OrderingService orderingService) {
        this.orderingService = orderingService;
    }

    @PostMapping
    public ResponseEntity<Ordering> saveOrdering(@RequestBody Ordering ordering) {
        return new ResponseEntity<>(orderingService.save(ordering), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Ordering>> findAllOrdering() {
        return new ResponseEntity<>(orderingService.findAll(), HttpStatus.OK);
    }
}
