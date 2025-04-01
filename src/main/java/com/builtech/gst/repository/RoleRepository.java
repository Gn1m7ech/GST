package com.builtech.gst.repository;


import com.builtech.gst.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query(value = "SELECT * FROM roles WHERE role = 'ADMIN' ", nativeQuery = true)
    Optional<Role> getAdminRole();

    @Query(value = "SELECT * FROM roles WHERE role = 'OWNER' ", nativeQuery = true)
    Optional<Role> getOwnerRole();

    @Query(value = "SELECT * FROM roles WHERE role = 'CLIENT' ", nativeQuery = true)
    Optional<Role> getClientRole();

}
