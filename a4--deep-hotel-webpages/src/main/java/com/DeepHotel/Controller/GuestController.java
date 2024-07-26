package com.DeepHotel.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.DeepHotel.ExceptionHandler.BadRequest;
import com.DeepHotel.ExceptionHandler.NotFound;
import com.DeepHotel.Model.Guest;
import com.DeepHotel.Repository.GuestRepo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController("api/guest")
@RequestMapping("api/guest")
public class GuestController {

	@Autowired
	GuestRepo guestRepo;

	@GetMapping
	public List<Guest> getAllGuests() {
		System.out.println("ii");
		return guestRepo.findAll();
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Guest postMethodName(@RequestBody Guest guest) {

		return guestRepo.save(guest);
	}

	@GetMapping("/{id}")
	public Guest getMethodName(@PathVariable long id) {

		return guestRepo.findById(id).orElseThrow(() -> new NotFound("Guest Not found!"));
	}

	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Guest putMethodName(@PathVariable String id, @RequestBody Guest guest) {

		return guestRepo.findById(null).orElseThrow(() -> new BadRequest("Based on '" + id + "' id guest is not found!"));
	}

	@DeleteMapping("/{id}")
	public void deleteGuest(@PathVariable long id) {
		
		if (guestRepo.findById(id).isPresent()) {
			guestRepo.deleteById(id);
		}else {
			new NotFound("No record found for deletion!");
		}
	}

}
