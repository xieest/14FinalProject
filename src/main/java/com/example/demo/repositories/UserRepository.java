package com.example.demo.repositories;

import com.example.demo.entities.User;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
   default boolean create(User user){
       System.out.printf("Alejandro's username is %s\n", user.getUserName());
       if( findById(user.getUserName()).isPresent()) {
         return false;

      }else if(!EmailValidator.getInstance().isValid(user.getUserName())) {
          return false;
      }else {
         save(user);
         return true;
      }
   }

    default boolean update(User user){
        if( findById(user.getUserName()).isEmpty()) {
            return false;
        }else {
            save(user);
            return true;
        }
    }

}
