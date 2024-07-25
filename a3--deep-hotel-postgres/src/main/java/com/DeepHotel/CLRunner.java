package com.DeepHotel;

import org.springframework.stereotype.Component;

import com.DeepHotel.Model.Room;
import com.DeepHotel.Repository.RoomRepo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@Component
public class CLRunner implements CommandLineRunner {
	
	@Autowired
	RoomRepo roomRepo;

	@Override
	public void run(String... args) throws Exception {

		roomRepo.findAll().stream().forEach(System.out::println);
		
		Optional<Room> room= roomRepo.findByRoomNumberIgnoreCase("p1");
		
		System.out.println(room);
		
		
		
	}

}
