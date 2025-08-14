package com.secure.notesApplication.repositories;

import com.secure.notesApplication.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUserName(String username);

    Boolean existsByEmail(String email);


    Boolean existsByUserName(String username);

    Optional<User> findByEmail(String email);
}
