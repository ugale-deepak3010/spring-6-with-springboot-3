package com.DeepHotel.Controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.DeepHotel.ExceptionHandler.BadRequest;
import com.DeepHotel.ExceptionHandler.NotFound;
import com.DeepHotel.Model.Reservation;
import com.DeepHotel.Repository.ReservationRepo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController("api/reservation")
@RequestMapping("api/reservation")
public class ReservationController {

	@Autowired
	ReservationRepo reservationRepo;

	@GetMapping
	public List<Reservation> getAllReservations() {
		System.out.println("ii");
		return reservationRepo.findAll();
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Reservation postMethodName(@RequestBody Reservation reservation) {

		return reservationRepo.save(reservation);
	}

	@GetMapping("/{id}")
	public Reservation getMethodName(@PathVariable long id) {

		return reservationRepo.findById(id).orElseThrow(() -> new NotFound("Reservation Not found!"));
	}

	@GetMapping("/{id}")
	public List<Reservation> getReservationByDate(@PathVariable Date resDate) {

		return reservationRepo.findByResDate(resDate);
	}

	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Reservation putMethodName(@PathVariable String id, @RequestBody Reservation reservation) {

		return reservationRepo.findById(null)
				.orElseThrow(() -> new BadRequest("Based on '" + id + "' id reservation is not found!"));
	}

	@DeleteMapping("/{id}")
	public void deleteReservation(@PathVariable long id) {

		if (reservationRepo.findById(id).isPresent()) {
			reservationRepo.deleteById(id);
		} else {
			new NotFound("No record found for deletion!");
		}
	}

}
