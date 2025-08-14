package com.secure.notesApplication.repositories;

import com.secure.notesApplication.models.AppRole;
import com.secure.notesApplication.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Optional<Role> findByRoleName(AppRole appRole);
}
