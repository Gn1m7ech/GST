package com.builtech.gst.repository;

import com.builtech.gst.entity.Client;
import com.builtech.gst.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
