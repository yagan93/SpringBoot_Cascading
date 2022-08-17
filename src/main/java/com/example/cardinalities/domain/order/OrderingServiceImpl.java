package com.example.cardinalities.domain.order;

import com.example.cardinalities.domain.orderingposition.OrderingPosition;
import com.example.cardinalities.domain.orderingposition.OrderingPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderingServiceImpl implements OrderingService {

    private final OrderingRepository orderingRepository;
    private final OrderingPositionService orderingPositionService;

    @Autowired
    public OrderingServiceImpl(OrderingRepository orderingRepository, OrderingPositionService orderingPositionService) {
        this.orderingRepository = orderingRepository;
        this.orderingPositionService = orderingPositionService;
    }

    @Override
    @Transactional
    public Ordering save(Ordering ordering) {
        Set<OrderingPosition> detachedPositions = ordering.getOrderingPositions();
        Ordering cachedOrdering = orderingRepository.save(ordering.setOrderingPositions(new HashSet<>()));
        cachedOrdering.setOrderingPositions(detachedPositions.stream().map(p -> p.setOrdering(cachedOrdering)).collect(Collectors.toSet()));
        return orderingRepository.save(cachedOrdering);
    }

    @Override
    public List<Ordering> findAll() {
        return orderingRepository.findAll();
    }

    private Ordering findOrThrow(Optional<Ordering> optional) throws NoSuchElementException {
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new NoSuchElementException("No value present");
        }
    }
}
