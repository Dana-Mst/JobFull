package com.rocketteam.jobfull;

import com.rocketteam.jobfull.utils.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class JobfullApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobfullApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/company/addCompany").allowedOrigins("http://localhost:3000");
				registry.addMapping("/api/customer/addCustomer").allowedOrigins("http://localhost:3000");
				registry.addMapping("/api").allowedOrigins("http://localhost:3000");
				registry.addMapping("/api/company/").allowedOrigins("http://localhost:3000");
			}
		};
	}
}
