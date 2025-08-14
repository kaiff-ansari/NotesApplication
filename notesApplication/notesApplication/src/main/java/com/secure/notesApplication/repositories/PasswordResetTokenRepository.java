package com.secure.notesApplication.repositories;

import com.secure.notesApplication.models.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken,Long> {


  Optional<PasswordResetToken> findByToken(String token);
}
