package com.panoslepipas.spring.project;

import com.panoslepipas.spring.project.models.Role;
import com.panoslepipas.spring.project.repositories.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@SpringBootApplication
public class Application {

	// creates a bean called RestTemplate to initialise @Autowired
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	//add a role in the database if there's none
	@Bean
	public CommandLineRunner loadInitialRoleData(RoleRepository roleRepository) {
		return (args) -> {
			if (((Collection<Role>)roleRepository.findAll()).size() == 0) {
				roleRepository.save(new Role("ADMIN"));
				roleRepository.save(new Role("USER"));
			}
		};
	}


}
