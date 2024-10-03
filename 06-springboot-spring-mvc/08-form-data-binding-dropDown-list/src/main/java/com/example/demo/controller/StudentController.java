package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Student;

@Controller
public class StudentController {

	//to use hardcoded-html drop down please remove the list object countries and line number 26 
	@Value("${countries}")
	private List<String> countries;

	@GetMapping("/showSudentForm")
	public String showForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		//remove the below line where countries is added as attribute
		model.addAttribute("country", countries);
		return "student-form";

	}

	@PostMapping("/processStudentForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		System.out.println(
				"First Name : " + theStudent.getFirstName() + " AND " + "Last Name : " + theStudent.getLastName());
		return "student-confirmation";
	}
}
