package com.DeepHotel.WebController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.DeepHotel.Repository.RoomRepo;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/room")
public class RoomController {

	@Autowired
	RoomRepo roomRepo;

	@GetMapping
	public String getMethodName(Model model) {
		model.addAttribute("rooms", roomRepo.findAll());
		return "room-list";
	}

}
