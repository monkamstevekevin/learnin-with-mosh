package org.codewithsteve.store.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Byte id;
    @Column(nullable = false, name ="name")
    private String name;
    @OneToMany(mappedBy = "category")
     private Set<Product> products = new HashSet<>();


}
