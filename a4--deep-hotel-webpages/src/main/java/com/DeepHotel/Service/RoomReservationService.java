package com.DeepHotel.Service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DeepHotel.Model.Guest;
import com.DeepHotel.Model.Reservation;
import com.DeepHotel.Model.Room;
import com.DeepHotel.Model.RoomReservation;
import com.DeepHotel.Repository.GuestRepo;
import com.DeepHotel.Repository.ReservationRepo;
import com.DeepHotel.Repository.RoomRepo;

@Service
public class RoomReservationService {

	@Autowired
	GuestRepo guestRepo;
	@Autowired
	RoomRepo roomRepo;
	@Autowired
	ReservationRepo reservationRepo;

	public List<RoomReservation> getRoomReservationForDate(String reservationDate) {

		Date resDate;

		if (reservationDate.isEmpty()) {
			resDate = new Date(new java.util.Date().getTime());
		} else {
			resDate = Date.valueOf(reservationDate);
		}

		// add initially all ReemReservations.
		Map<Long, RoomReservation> roomReservationMap = new HashMap<Long, RoomReservation>();

		List<Room> rooms = roomRepo.findAll();

		rooms.forEach(room -> {
			RoomReservation roomReservation = RoomReservation.builder().roomId(room.getId()).roomName(room.getName())
					.roomNumber(room.getRoomNumber()).build();

			roomReservationMap.put(roomReservation.getRoomId(), roomReservation);
		});

		List<Reservation> reservations = reservationRepo.findAll();

		reservations.forEach(res -> {
			RoomReservation roomReservation = roomReservationMap.get(res.getRoomId());

			roomReservation.setReservationId(res.getId());
			roomReservation.setReservationDate(res.getResDate().toString());
			
			Optional<Guest> guest= guestRepo.findById(res.getGuestId());
			
			roomReservation.setGuestId(guest.get().getId());
			roomReservation.setFirstName(guest.get().getFirstName());
			roomReservation.setLastName(guest.get().getLastName());
			
		});

		return roomReservationMap.values().stream().toList();

	}




























}
