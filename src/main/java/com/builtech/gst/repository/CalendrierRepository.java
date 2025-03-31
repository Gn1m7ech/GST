package com.builtech.gst.repository;

import com.builtech.gst.entity.Calendrier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendrierRepository extends JpaRepository<Calendrier, Long> {

}
