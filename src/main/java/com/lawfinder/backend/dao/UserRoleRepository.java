package com.lawfinder.backend.dao;
import com.lawfinder.backend.Entity.RoleEntity;
import com.lawfinder.backend.Entity.UserRoleEntity;
import com.lawfinder.backend.dto.UserRoleDto;
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


    @Query("SELECT r.roleName FROM RoleEntity r " +
            "JOIN UserRoleEntity ur ON r.roleId = ur.role.roleId " +
            "JOIN UserEntity u ON u.id = ur.user.id " +
            "WHERE r.status = 1 AND ur.status = true AND u.id = :userId")
    List<String> findRolesByUserId(@Param("userId") Long userId);


    @Query("SELECT ur FROM UserRoleEntity ur " +
            "JOIN UserEntity u ON u.id = ur.user.id " +
            "WHERE u.id = :userId AND ur.status = true")
    List<UserRoleEntity> findByUser_Id(Long userId);

    //encontrar el nombre del rol por userroleID
    @Query("SELECT r.roleName FROM RoleEntity r " +
            "JOIN UserRoleEntity ur ON r.roleId = ur.role.roleId " +
            "WHERE ur.userRoleId = :userRoleId")
    String findRoleNameByUserRoleId(@Param("userRoleId") Long userRoleId);


    @Query("SELECT ur FROM UserRoleEntity ur " +
            "JOIN UserEntity u ON u.id = ur.user.id " +
            "JOIN RoleEntity r ON r.roleId = ur.role.roleId " +
            "WHERE u.id = :userId AND r.roleId = :roleId AND ur.status = true")
    UserRoleEntity findByUser_IdAndRole_Id(Long userId, Long roleId);

    @Query("SELECT ur FROM UserRoleEntity ur " +
            "JOIN UserEntity u ON u.id = ur.user.id " +
            "JOIN RoleEntity r ON r.roleId = ur.role.roleId " +
            "WHERE u.id = :userId AND r.roleId = :roleId")
    UserRoleEntity findWithoutStatus(Long userId, Long roleId);


}
