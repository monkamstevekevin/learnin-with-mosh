package org.codewithsteve.store.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Byte id;
    @Column(nullable = false, name ="name")
    private String name;
    @OneToMany(mappedBy = "category",cascade = {CascadeType.PERSIST,CascadeType.REMOVE},orphanRemoval = true)
     private Set<Product> products = new HashSet<>();
     public void addProduct(Product product) {
          if(products == null) products = new HashSet<>();
         products.add(product);
         product.setCategory(this);
     }


}
