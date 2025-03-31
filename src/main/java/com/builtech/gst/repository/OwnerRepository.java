package com.builtech.gst.repository;

import com.builtech.gst.entity.Client;
import com.builtech.gst.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

}
