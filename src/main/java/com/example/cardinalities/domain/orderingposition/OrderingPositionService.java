package com.example.cardinalities.domain.orderingposition;

import java.util.List;

public interface OrderingPositionService {
    List<OrderingPosition> saveAll(List<OrderingPosition> orderingPositions);
}
