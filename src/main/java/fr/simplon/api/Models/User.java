package fr.simplon.api.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;


@Entity
@Data
@RequiredArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, unique = true)
    @NonNull
    private String username;

    private String name;
    private String email;
    @JsonIgnore
    private String password;

    @JsonIgnore
    @OneToOne(mappedBy = "user")
    private Card card;

    public User() {

    }

}
