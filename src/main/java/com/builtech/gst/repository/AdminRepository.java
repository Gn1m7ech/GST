package com.builtech.gst.repository;

import com.builtech.gst.entity.Admin;
import com.builtech.gst.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

}
