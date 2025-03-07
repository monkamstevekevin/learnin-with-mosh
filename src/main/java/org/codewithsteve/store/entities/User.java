package org.codewithsteve.store.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table  (name = "users")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false,name = "name")
    private String name;
    @Column(nullable = false,name = "email")
    private String email;
    @Column(nullable = false,name = "password")
    private String password;
    @OneToMany(mappedBy = "user",cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    @ToString.Exclude
    private List<Address> addresses = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "user_tags",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags =  new HashSet<>();
    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    private Profile profile;
    @ManyToMany
    @JoinTable(name = "whishlist",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> favoriteProducts = new HashSet<>();
    public void addAddress(Address address){
        if(addresses==null){
            addresses = new ArrayList<>();
        }
        addresses.add(address);
        address.setUser(this);
    }
 public void removeAddress(Address address){
        addresses.remove(address);
        address.setUser(null);
    }
    public void addTag(Tag tag){
        tags.add(tag);
        tag.getUsers().add(this);
    }
    public void removeTag(Tag tag){
        tags.remove(tag);
        tag.getUsers().remove(this);
    }
     public void addFavoriteProduct(Product product){
        favoriteProducts.add(product);

     }


}
