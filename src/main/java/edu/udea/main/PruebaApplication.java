package edu.udea.main;

import edu.udea.main.security.SuccesGoogle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PruebaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaApplication.class, args);
	}


	//@Bean
	//public SuccesGoogle getSuccesGoogle(){
	//	return new SuccesGoogle();
	//}

}
