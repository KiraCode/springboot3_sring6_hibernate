package com.example.component.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.component.common.Coach;

@RestController
public class DemoController {

	private Coach coach;
	
	@Autowired
	public DemoController(Coach coach) {
		this.coach = coach;
	}
	
	@GetMapping("/daily-workout")
	public String dailyWorkout() {
		return coach.getWorkOutDaily();
	}
}
