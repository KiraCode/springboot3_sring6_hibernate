package com.crud.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.crud.demo.dao.StudentDao;
import com.crud.demo.entity.Student;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao student) {
		return runner -> {
			createStudent(student);

			createMultipleStudents(student);
		};

	}

	private void createMultipleStudents(StudentDao studentDao) {

		System.out.println("Cretaing 3 Student Object... ");
		Student student1 = new Student("John", "Wick", "johnwick@gmail.com");
		Student student2 = new Student("Mary", "Blake", "maryblake@gmail.com");
		Student student3 = new Student("Bonita", "Ronita", "bonitaronita@gmail.com");

		System.out.println("Saving the Student... ");
		studentDao.save(student1);
		studentDao.save(student2);
		studentDao.save(student3);

		System.out.println("Saved Student/ Generated Id: " + student1.getId());
		System.out.println("Saved Student/ Generated Id: " + student2.getId());
		System.out.println("Saved Student/ Generated Id: " + student3.getId());

	}

	private void createStudent(StudentDao studentDao) {
		System.out.println("Cretaing new Student Object... ");
		Student student = new Student("Paul", "HeyMan", "paulheyman@gmail.com");

		System.out.println("Saving the Student... ");
		studentDao.save(student);

		System.out.println("Saved Student/ Generated Id: " + student.getId());
	}

}
