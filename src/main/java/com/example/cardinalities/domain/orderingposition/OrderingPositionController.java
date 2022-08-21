package com.example.cardinalities.domain.orderingposition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orderingPositions")
public class OrderingPositionController {

    private OrderingPositionService orderingPositionService;

    @Autowired
    public OrderingPositionController(OrderingPositionService orderingPositionService) {
        this.orderingPositionService = orderingPositionService;
    }

    @GetMapping
    public ResponseEntity<List<OrderingPosition>> findAllOrderingPositions () {
        return new ResponseEntity<>(orderingPositionService.findAll(), HttpStatus.OK);
    }
}
