package com.example.demo;

import com.example.demo.models.Customer;
import com.example.demo.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
* 목표 - 주소창에 주소를 입력했을 때
* 내가 만든 html이 보이도록 해보
* http://localhost:8080/home
* */
@SpringBootApplication
@RestController
public class DemoApplication {
	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);


	// 현재 실행중인 Ioc Container를 반환한다.
	// 그리고 Ioc Container는 클래스를 객체로 만들어서 내부에서 관리한다.
	public static void main(String[] args) {

//		ApplicationContext applicationContext =
				SpringApplication.run(DemoApplication.class, args);

		// 그 Container가 어떤 Bean 객체를 가지고 있는지 확인해보자.
//		for (String beanName : applicationContext.getBeanDefinitionNames()) {
//			System.out.println(beanName);
//		}
	}



//	@Bean
//	public CommandLineRunner demo(CustomerRepository repository) {
//		return args -> {
//			repository.save(new Customer("leo", "aa"));
//			repository.save(new Customer("you", "bb"));
//			repository.save(new Customer("jun", "cc"));
//			repository.save(new Customer("leo2", "aa"));
//
//			log.info("FindAll---------------------");
//
//
//			for (Customer customer : repository.findAll()) {
//				log.info(customer.toString());
//			}
//			log.info("");
//			log.info("findById---------------------");
//			Customer customer = repository.findById(1L);
//			log.info(customer.toString());
//			log.info("");
//
//			log.info("findByLastName---------------------");
//			repository.findByLastName("aa").forEach(c -> {log.info(c.toString());});
//			log.info("");

//		};


}
