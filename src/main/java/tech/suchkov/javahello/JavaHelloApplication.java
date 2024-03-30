package tech.suchkov.javahello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@SpringBootApplication
@RestController
public class JavaHelloApplication {

	String[] emojis = {"🐳", "🐬", "🐶", "🦁"};
	Random random = new Random();

	public static void main(String[] args) {
		SpringApplication.run(JavaHelloApplication.class, args);
	}

	@GetMapping("/")
	public String helloWorld() {
		int index = random.nextInt(emojis.length);
		return String.format("Hello from Java in Docker %s", emojis[index]);
	}
}
