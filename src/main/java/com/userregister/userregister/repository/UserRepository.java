package com.userregister.userregister.repository;

import com.userregister.userregister.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Integer>{
    
}
