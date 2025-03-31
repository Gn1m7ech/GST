package com.builtech.gst.repository;


import com.builtech.gst.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("SELECT r FROM roles r WHERE r.role LIKE 'ADMIN' ")
    Optional<Role> getAdminRole();

    @Query("SELECT r FROM roles r WHERE r.role LIKE 'OWNER' ")
    Optional<Role> getOwnerRole();

    @Query("SELECT r FROM roles r WHERE r.role LIKE 'CLIENT' ")
    Optional<Role> getClientRole();

}
