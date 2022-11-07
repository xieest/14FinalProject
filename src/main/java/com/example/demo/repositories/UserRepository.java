package com.example.demo.repositories;

import com.example.demo.entities.CreateUserRequest;
import com.example.demo.entities.UpdateUserRequest;
import com.example.demo.entities.User;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
   default boolean create(CreateUserRequest createUserRequest){
       if( findById(createUserRequest.getUserName()).isPresent()) {
         return false;

      }else if(!EmailValidator.getInstance().isValid(createUserRequest.getUserName())) {
          return false;
      }else {
           User user = new User();
           user.setUserName(createUserRequest.getUserName());
           user.setPassword(createUserRequest.getPassword());
           user.setHomeAddress(createUserRequest.getHomeAddress());
           user.setFirstName(createUserRequest.getFirstName());
           user.setLastName(createUserRequest.getLastName());
           save(user);
           return true;
      }
   }

    default boolean update(UpdateUserRequest updateUserRequest) {
        return findById(updateUserRequest.getUserName()).map(user -> {
            user.setUserName(updateUserRequest.getUserName());
            user.setPassword(updateUserRequest.getPassword());
            user.setHomeAddress(updateUserRequest.getHomeAddress());
            user.setFirstName(updateUserRequest.getFirstName());
            user.setLastName(updateUserRequest.getLastName());
            save(user);
            return true;
        }).orElse(false);
    }

}
