package br.com.macedo.jasper.jasperteste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.com.macedo.jasper.*")
public class JasperTesteApplication {

	public static void main(String[] args) {
		SpringApplication.run(JasperTesteApplication.class, args);
	}

}
