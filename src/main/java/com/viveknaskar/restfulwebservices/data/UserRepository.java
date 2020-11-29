package com.viveknaskar.restfulwebservices.data;

import com.viveknaskar.restfulwebservices.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
