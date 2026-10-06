package sistema_rh;
// pasta raiz do projeto (o Spring só enxerga o que está aqui dentro)

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/// Classe principal do programa: é o botão de "start".
// É daqui que o Spring Boot inicia a aplicação e conecta todas as partes.
// Sozinha ela não faz nada de útil: apenas liga o sistema.
// O trabalho real é feito pelas outras classes (controllers, services, repositories).
@SpringBootApplication // esse comando avisa o spring boot que aqui e a classe principaç e ajeits tudo dentro da pasta sistema rh
public class BackendApplication {


	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	// Sobe o servidor, conecta no banco e deixa a API pronta



}
