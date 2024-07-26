package com.DeepHotel.WebController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.DeepHotel.Service.RoomReservationService;

@Controller
@RequestMapping("/occupancy")
public class OccupancyController {

	@Autowired
	RoomReservationService roomReservationService;

	@GetMapping
	public String getMethodName(Model model, @RequestParam(required = false) String resDate) {

		Date date = new Date();
		String todaysDate = new String();

		String finalDate = new String();

		boolean getAll = false;

		if (resDate != null) {

			try {
//				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//				date = simpleDateFormat.parse(resDate);

				LocalDate date2 = LocalDate.parse(resDate, DateTimeFormatter.ISO_DATE);

				System.err.println(date);
				System.out.println("--");
				System.err.println(date2);
				finalDate = date2.toString();

			} catch (Exception e) {
				System.err.println("exception caught in parsing date: " + e.getMessage());
			}
		} else {

			getAll = true;
			todaysDate = LocalDate.now().toString();
			resDate=todaysDate;
			finalDate = todaysDate;
		}

		System.err.println("1: " + finalDate);
		System.err.println("2: " + resDate);
		model.addAttribute("date", finalDate);
		model.addAttribute("reservations", roomReservationService.getRoomReservationForDate(resDate, getAll));

		return "occupancy";
	}

}
