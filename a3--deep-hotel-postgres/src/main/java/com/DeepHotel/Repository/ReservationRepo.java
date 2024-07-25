package com.DeepHotel.Repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DeepHotel.Model.Reservation;

public interface ReservationRepo extends JpaRepository<Reservation, Long> {

	List<Reservation> findByResDate(Date resDate);
}
