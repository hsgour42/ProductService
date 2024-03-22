package com.example.productservice;

import com.example.productservice.inheritancerelation.singletable.*;
import com.example.productservice.models.Category;
import com.example.productservice.models.Order;
import com.example.productservice.models.Price;
import com.example.productservice.models.Product;
import com.example.productservice.repositories.CategoryRepository;
import com.example.productservice.repositories.OrderRepository;
import com.example.productservice.repositories.PriceRepository;
import com.example.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


//Flaky Test Case : Something it may pass sometime it may fail  //Random

//Control + option + O to remove all unnecessary import

@SpringBootApplication()
//implements  CommandLineRunner
public class ProductServiceApplication {


//		private final MentorRepository mentorRepository;
//	private final   StudentRepository studentRepository;
//	private final UserRepository userRepository;
//	private final CategoryRepository categoryRepository;
//	private final ProductRepository productRepository;
//	private final PriceRepository priceRepository;
//	private final OrderRepository orderRepository;
//
//	@Autowired
//	 public ProductServiceApplication(
//			 @Qualifier("s_mentorRepository") MentorRepository mentorRepository,
//			 @Qualifier("s_studentRepository") StudentRepository studentRepository,
//			 @Qualifier("s_userRepository") UserRepository userRepository,
//
//			 CategoryRepository categoryRepository,
//			 ProductRepository productRepository,
//			 PriceRepository priceRepository,
//			 OrderRepository orderRepository){
//		this.mentorRepository = mentorRepository;
//		this.studentRepository = studentRepository;
//		this.userRepository = userRepository;
//		this.categoryRepository = categoryRepository;
//		this.productRepository = productRepository;
//		this.priceRepository = priceRepository;
//		this.orderRepository = orderRepository;
//	}

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
//	@Override
//	public void run(String... args) throws Exception {
		//Inheritance
//		Mentor mentor = new Mentor();
//		mentor.setName("harsh");
//		mentor.setEmail("harsh@gmail.com");
//		mentor.setAvgRating(4.7);
//		Mentor mentor1	= mentorRepository.save(mentor);
//
//		Student student	= new Student();
//		student.setPsp(10);
//		student.setEmail("Himanshu@gmail.com");
//		student.setName("Himanshu");
//		Student student1 = studentRepository.save(student);
//
//		User user = new User();
//		user.setName("Vijay");
//		user.setEmail("Vijay@gmail.com");
//		User user1 = userRepository.save(user);
//
//		 List<User> users = userRepository.findAll();
//
//		 for(User user2 : users){
//			 System.out.println(user2.toString());
//
//		 }

		//Relationship
//		Category appleCategory = new Category();
//		appleCategory.setName("Apple");
//		Category savedAppleCategory = categoryRepository.save(appleCategory);
//
//		Price apple15Price= new Price();
//		apple15Price.setCurrency("INR");
//		apple15Price.setValue(73000);
//		Price savedApplePrice = priceRepository.save(apple15Price);
//
//		Product apple15Product= new Product();
//		apple15Product.setCategory(appleCategory);
//		apple15Product.setImage("/url/iphone15promax.jpg");
//		apple15Product.setTitle("Iphone");
//		apple15Product.setPrice(savedApplePrice);
//		apple15Product.setDescription("Iphone 15 pro max");
//		productRepository.save(apple15Product);
//
//
//		Price apple14Price= new Price();
//		apple14Price.setCurrency("INR");
//		apple14Price.setValue(53000);
//		Price savedApple14Price = priceRepository.save(apple14Price);
//
//		Product apple14Product= new Product();
//		apple14Product.setCategory(savedAppleCategory);
//		apple14Product.setImage("/url/iphone14pro.jpg");
//		apple14Product.setTitle("Iphone");
//		apple14Product.setPrice(savedApple14Price);
//		apple14Product.setDescription("Iphone 14 pro");
//		productRepository.save(apple14Product);
//
//
//
//		Price sumsungPrice= new Price();
//		sumsungPrice.setCurrency("INR");
//		sumsungPrice.setValue(102000);
//		Price savedSumsungPrice = priceRepository.save(sumsungPrice);
//
//		Category samsungCategory = new Category();
//		samsungCategory.setName("Samsung");
//		Category savedSamsungCategory = categoryRepository.save(samsungCategory);
//
//		Product sumsungS23UltraProduct	= new Product();
//		sumsungS23UltraProduct.setCategory(savedSamsungCategory);
//		sumsungS23UltraProduct.setImage("/url/SamsungUltra.jpg");
//		sumsungS23UltraProduct.setTitle("Samsung Ultra");
//		sumsungS23UltraProduct.setPrice(savedSumsungPrice);
//		sumsungS23UltraProduct.setDescription("Samsung Ultra 120");
//		productRepository.save(sumsungS23UltraProduct);
//
//
//
//	}
}
