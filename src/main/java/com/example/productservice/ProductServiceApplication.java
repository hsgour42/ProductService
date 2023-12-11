package com.example.productservice;

import com.example.productservice.inheritancerelation.singletable.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


//Control + option + O to remove all unnecessary import
@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {
	private final MentorRepository mentorRepository;
	private final   StudentRepository studentRepository;
	private final UserRepository userRepository;

	@Autowired
	 public ProductServiceApplication(
			 @Qualifier("s_mentorRepository") MentorRepository mentorRepository,
			 @Qualifier("s_studentRepository") StudentRepository studentRepository,
			 @Qualifier("s_userRepository") UserRepository userRepository

	){
		this.mentorRepository = mentorRepository;
		this.studentRepository = studentRepository;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Mentor mentor = new Mentor();
		mentor.setName("harsh");
		mentor.setEmail("harsh@gmail.com");
		mentor.setAvgRating(4.7);
		Mentor mentor1	= mentorRepository.save(mentor);

		Student student	= new Student();
		student.setPsp(10);
		student.setEmail("Himanshu@gmail.com");
		student.setName("Himanshu");
		Student student1 = studentRepository.save(student);

		User user = new User();
		user.setName("Vijay");
		user.setEmail("Vijay@gmail.com");
		User user1 = userRepository.save(user);

		 List<User> users = userRepository.findAll();

		 for(User user2 : users){
			 System.out.println(user2.toString());

		 }

	}
}
