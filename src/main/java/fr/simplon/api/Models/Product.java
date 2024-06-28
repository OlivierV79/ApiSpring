package fr.simplon.api.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, unique = true)
    @NonNull
    private String name;

    @Column(nullable = false)
    @NonNull
    private Float price;


//    @OneToMany(mappedBy = "products")
//    private List<Line> lines;

    public Product() {

    }

    public Product(String name) {
    }
}
