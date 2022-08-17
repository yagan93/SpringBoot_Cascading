package com.example.cardinalities.domain.orderingposition;

import com.example.cardinalities.domain.order.Ordering;
import com.example.cardinalities.domain.product.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class OrderingPosition {

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

    @ManyToOne()
    @JoinColumn(name = "ordering_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private Ordering ordering;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private Product product;

    private int amount;

    public OrderingPosition() {
    }

    public OrderingPosition(UUID id, Ordering ordering, Product product, int amount) {
        this.id = id;
        this.ordering = ordering;
        this.product = product;
        this.amount = amount;
    }

    public UUID getId() {
        return id;
    }

    public OrderingPosition setId(UUID id) {
        this.id = id;
        return this;
    }

    public Ordering getOrdering() {
        return ordering;
    }

    public OrderingPosition setOrdering(Ordering ordering) {
        this.ordering = ordering;
        return this;
    }

    public Product getProduct() {
        return product;
    }

    public OrderingPosition setProduct(Product product) {
        this.product = product;
        return this;
    }

    public int getAmount() {
        return amount;
    }

    public OrderingPosition setAmount(int amount) {
        this.amount = amount;
        return this;
    }
}

