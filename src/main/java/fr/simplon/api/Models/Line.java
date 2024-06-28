package fr.simplon.api.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@Table
public class Line {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Line(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;

    }
}
