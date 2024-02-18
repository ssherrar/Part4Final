package org.example.part4final.interfaces;

import org.example.part4final.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {

}
