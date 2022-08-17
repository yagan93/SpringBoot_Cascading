package com.example.cardinalities.domain.order;

import com.example.cardinalities.domain.orderingposition.OrderingPosition;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Ordering {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                    )
            }
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    /* Cascading
    Which DB operations to the target entity (Ordering)
    should be applied to the associated entity (OrderingPosition) as well?

    Possible CascadeTypes = {PERSIST, MERGE, REMOVE, REFRESH, DETACH}
    - PERSIST
        When we save the Ordering, the OrderingPositions will also get saved (SQL INSERT INTO)
    - MERGE
        When we modify the Ordering, pending changes in the OrderingPositions get committed as well (SQL UPDATE)
    - REMOVE
        When we remove the Ordering, all its OrderingPositions get deleted as well (SQL DELETE FROM)
    - REFRESH
        When we reload the Ordering, the OrderingPositions get refreshed as well

    Reference: https://www.baeldung.com/jpa-cascade-types */
    @OneToMany(
            mappedBy = "ordering",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private Set<OrderingPosition> orderingPositions = new HashSet<>();

    public Ordering() {
    }

    public Ordering(UUID id, Set<OrderingPosition> orderingPositions) {
        this.id = id;
        this.orderingPositions = orderingPositions;
    }

    public UUID getId() {
        return id;
    }

    public Ordering setId(UUID id) {
        this.id = id;
        return this;
    }

    public Set<OrderingPosition> getOrderingPositions() {
        return orderingPositions;
    }

    public Ordering setOrderingPositions(Set<OrderingPosition> orderingPositions) {
        this.orderingPositions = orderingPositions;
        return this;
    }
}
