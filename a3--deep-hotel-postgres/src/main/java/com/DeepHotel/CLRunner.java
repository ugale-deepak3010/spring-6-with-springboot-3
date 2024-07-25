package com.DeepHotel;

import org.springframework.stereotype.Component;

import com.DeepHotel.Model.Room;
import com.DeepHotel.Repository.GuestRepo;
import com.DeepHotel.Repository.ReservationRepo;
import com.DeepHotel.Repository.RoomRepo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@Component
public class CLRunner implements CommandLineRunner {
	
	@Autowired
	RoomRepo roomRepo;
	
	@Autowired
	GuestRepo guestRepo;

	@Autowired
	ReservationRepo reservationRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		System.err.println("**** GUESTS ****");
		guestRepo.findAll().forEach(System.out::println);
		
		System.err.println("**** RESERVATIONS ****");
		reservationRepo.findAll().forEach(System.out::println);
		

		System.err.println("**** ROOMS ****");
		roomRepo.findAll().forEach(System.out::println);
		
		
		Optional<Room> room= roomRepo.findByRoomNumberIgnoreCase("p1");
		System.out.println(room);
		
		
		
	}

}
