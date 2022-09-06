package br.com.allan.pontodefuncao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class PontoDeFuncaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PontoDeFuncaoApplication.class, args);
		System.out.println("Senha: "+new BCryptPasswordEncoder().encode("teste@123"));
		
		
	}
	@Bean 
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
	    return new BCryptPasswordEncoder(); 
	}

}
