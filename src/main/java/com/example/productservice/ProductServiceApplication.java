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


//Control + option + O to remove all unnecessary import
@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {
	private final MentorRepository mentorRepository;
	private final   StudentRepository studentRepository;
	private final UserRepository userRepository;
	private final CategoryRepository categoryRepository;
	private final ProductRepository productRepository;
	private final PriceRepository priceRepository;
	private final OrderRepository orderRepository;

	@Autowired
	 public ProductServiceApplication(
			 @Qualifier("s_mentorRepository") MentorRepository mentorRepository,
			 @Qualifier("s_studentRepository") StudentRepository studentRepository,
			 @Qualifier("s_userRepository") UserRepository userRepository,

			 CategoryRepository categoryRepository,
			 ProductRepository productRepository,
			 PriceRepository priceRepository,
			 OrderRepository orderRepository){
		this.mentorRepository = mentorRepository;
		this.studentRepository = studentRepository;
		this.userRepository = userRepository;
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
		this.priceRepository = priceRepository;
		this.orderRepository = orderRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
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
//		Category category = new Category();
//		category.setName("Apple");
//
//		Category category1 = categoryRepository.save(category);

//		Optional<Category> category1 = categoryRepository.findById(UUID.fromString("70b1b2c9-47de-43ab-8e0c-e2f145852fe3"));
//
//
//		Product product	= new Product();
//		product.setCategory(category1.get());
//		product.setImage("/url/iphone15promax.jpg");
//		product.setTitle("Iphone");
//		product.setPrice(800000);
//		product.setDescription("Iphone 15 pro max");
//
//		productRepository.save(product);

//		 Optional<Category> optionalCategory = categoryRepository.findById(UUID.fromString("70b1b2c9-47de-43ab-8e0c-e2f145852fe3"));
//		 if(optionalCategory.isEmpty()){
//			 throw new Exception("Category not available");
//		 }
//
//		 Category category	= optionalCategory.get();
//
//	 	List<Product> productList = category.getProducts();
//
//		 for(Product product : productList){
//			 System.out.println(product.getDescription());
//		 }


		Price price	= new Price();
		price.setCurrency("INR");
		price.setValue(895985);
		Price savedPrice = priceRepository.save(price);

		Category category = new Category();
		category.setName("Samsung");
		Category savedCategory = categoryRepository.save(category);

		Product product	= new Product();
		product.setCategory(savedCategory);
		product.setImage("/url/SamsungUltra.jpg");
		product.setTitle("Samsung Ultra");
		product.setPrice(savedPrice);
		product.setDescription("Samsung Ultra 120");
		productRepository.save(product);



	}
}
