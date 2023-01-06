package tn.esprit._3cinfogl1.springbootfirstproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringBootFirstProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootFirstProjectApplication.class, args);
    }

}
