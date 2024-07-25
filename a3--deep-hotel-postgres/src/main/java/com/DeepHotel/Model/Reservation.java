package com.DeepHotel.Model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "RESERVATIONS")
public class Reservation {
	
	/*
	 * RESERVATION_ID BIGSERIAL PRIMARY KEY,
  ROOM_ID BIGINT NOT NULL,
  GUEST_ID BIGINT NOT NULL,
  RES_DATE DATE
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RESERVATION_ID")
	long id;
	
	
	long roomId;
	long guestId;
	
	Date resDate;
	
	

}
