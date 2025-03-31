package com.builtech.gst.repository;

import com.builtech.gst.entity.Client;
import com.builtech.gst.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
