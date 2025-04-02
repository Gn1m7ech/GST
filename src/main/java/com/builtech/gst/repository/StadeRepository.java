package com.builtech.gst.repository;

import com.builtech.gst.entity.Stade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StadeRepository extends JpaRepository<Stade, Long> {
    @Query(value = "SELECT * FROM stades WHERE location = ?1 ", nativeQuery = true)
    Optional<Stade> findByLocalisation(String location);
}
