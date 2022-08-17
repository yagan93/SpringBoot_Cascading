package com.example.cardinalities.domain.order;

import java.util.List;

public interface OrderingService {
    Ordering save(Ordering ordering);

    List<Ordering> findAll();
}
