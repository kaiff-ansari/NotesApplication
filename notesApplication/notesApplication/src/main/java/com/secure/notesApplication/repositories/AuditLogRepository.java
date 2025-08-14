package com.secure.notesApplication.repositories;

import com.secure.notesApplication.models.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {


    List<AuditLog> findByNoteId(Long id);
}
