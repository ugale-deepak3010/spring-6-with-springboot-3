package com.DeepHotel.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.DeepHotel.ExceptionHandler.BadRequest;
import com.DeepHotel.ExceptionHandler.NotFound;
import com.DeepHotel.Model.Room;
import com.DeepHotel.Repository.RoomRepo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController("api/room")
@RequestMapping("api/room")
public class RoomController {

	@Autowired
	RoomRepo roomRepo;

	@GetMapping
	public List<Room> getAllRooms() {
		System.out.println("ii");
		return roomRepo.findAll();
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Room postMethodName(@RequestBody Room room) {

		return roomRepo.save(room);
	}

	@GetMapping("/{id}")
	public Room getMethodName(@PathVariable long id) {

		return roomRepo.findById(id).orElseThrow(() -> new NotFound("Room Not found!"));
	}

	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Room putMethodName(@PathVariable String id, @RequestBody Room room) {

		return roomRepo.findById(null).orElseThrow(() -> new BadRequest("Based on '" + id + "' id room is not found!"));
	}

	@DeleteMapping("/{id}")
	public void deleteRoom(@PathVariable long id) {
		
		if (roomRepo.findById(id).isPresent()) {
			roomRepo.deleteById(id);
		}else {
			new NotFound("No record found for deletion!");
		}
	}

}
