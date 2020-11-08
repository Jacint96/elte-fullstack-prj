package hu.elte.clothingwebshop;

import hu.elte.clothingwebshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClothingwebshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClothingwebshopApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

}
