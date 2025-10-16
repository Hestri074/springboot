package id.go.bpddiy.social;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// @EntityScan(basePackages = { "id.go.bpddiy.social.model" })
// @EnableJpaRepositories
public class SocialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialApplication.class, args);
	}

}
