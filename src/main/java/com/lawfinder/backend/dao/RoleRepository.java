package com.lawfinder.backend.dao;

import com.lawfinder.backend.Entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.management.relation.Role;
import java.util.List;


public interface RoleRepository extends JpaRepository<RoleEntity,Long> {
    @Query("SELECT r FROM RoleEntity r WHERE r.roleName = :role")
    RoleEntity findByRole(@Param("role") String role);

    @Query("SELECT r.roleName FROM RoleEntity r WHERE r.roleId = :roleId")
    String findRoleNameByRoleId(@Param("roleId") Long roleId);

    @Query("SELECT r FROM RoleEntity r WHERE r.roleId = :roleId")
    RoleEntity findByRoleId(Long roleId);

    List<RoleEntity> findAllByStatus(int status);
}
