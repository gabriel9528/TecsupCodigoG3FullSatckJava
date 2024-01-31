package com.OneToMany.PublicacionesComentarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PublicacionesComentariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PublicacionesComentariosApplication.class, args);
	}

}
