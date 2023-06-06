package com.lawfinder.backend.dao;
import com.lawfinder.backend.Entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity,Long> {

    @Query("SELECT DISTINCT p.priv FROM PrivilegeEntity p " +
            "JOIN PrivilegeRoleEntity pr ON p.privilegeId = pr.privilege.privilegeId " +
            "JOIN RoleEntity r ON r.roleId = pr.role.roleId " +
            "JOIN UserRoleEntity ur ON ur.role.roleId = r.roleId " +
            "JOIN UserEntity u ON u.id = ur.user.id " +
            "WHERE p.status = 1 AND pr.status = 1 AND r.status = 1 AND ur.status = true AND u.id = :userId")
    List<String> findPrivilegesByUserId(@Param("userId") Long userId);
}