package com.cwh.StudentManagementSystem.Repository;

import com.cwh.StudentManagementSystem.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {

  boolean existsByUsername(String username); // ✅ FIXED
}
