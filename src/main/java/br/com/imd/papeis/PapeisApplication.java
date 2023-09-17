package br.com.imd.papeis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "br.com.imd")
@EnableJpaRepositories("br.com.imd")
@EntityScan("br.com.imd")
public class PapeisApplication {
    public static void main(String[] args) {
        SpringApplication.run(PapeisApplication.class, args);
    }
}
