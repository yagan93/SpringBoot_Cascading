package com.example.cardinalities.domain.orderingposition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderPositionServiceImpl implements OrderingPositionService {

    private final OrderingPositionRepository orderingPositionRepository;

    @Autowired
    public OrderPositionServiceImpl(OrderingPositionRepository orderingPositionRepository) {
        this.orderingPositionRepository = orderingPositionRepository;
    }

    @Override
    public List<OrderingPosition> findAll() {
        return orderingPositionRepository.findAll();
    }
}
