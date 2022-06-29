package proy.serpost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProySerpostApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProySerpostApplication.class, args);
		System.out.println("Proyecto listo");
		
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
