package org.codewithsteve.store.services;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.codewithsteve.store.entities.Address;
import org.codewithsteve.store.entities.User;
import org.codewithsteve.store.repositories.AddressRepository;
import org.codewithsteve.store.repositories.ProfileRepository;
import org.codewithsteve.store.repositories.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Component
public class userService {
     private final UserRepository repository;
     private final ProfileRepository profileRepository;
      private final AddressRepository addressRepository;
     private final EntityManager em;
    private final UserRepository userRepository;

    @Transactional
     public void showEntityStates(){
         var user  =  User.builder().name("John Doe").
                     email("john@gmail.com").
                     password("password").build();
         if(em.contains(user)){
             System.out.println("persistent");
         }
         else{
             System.out.println("Transient ot detached");;
         }
         repository.save(user);
         if(em.contains(user)){
             System.out.println("persistent");
         }
         else{
             System.out.println("Transient ot detached");;
         }
     }
     @Transactional
public void showRelatedEntities(){
var address  =  addressRepository.findById(1L).orElseThrow();
         System.out.println(address.getState());
}
 public void persistRelatedEntity(){
         var user  =  User.builder().name("Paul").email("carldrogo@emai.com").password("password").build();
        var address  =  Address.builder().state("New York").city("carlifornia").zip("zip").street("street").build();
         user.addAddress(address);
          repository.save(user);
 }
  public void deletingRelatedEntity(){
         repository.deleteById(3L);
  }
  public void profileManagement(){
       var users =   userRepository.findLoyalUsers(2);
       users.forEach( user -> {
           System.out.println(user.getId()+" : " + user.getEmail());
       });
  }

}
