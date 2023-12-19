package demo.application.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories({"demo.application.backend.*"})
@EntityScan({"demo.application.backend.*"})
@ComponentScan({"demo.application.backend.*"})
class DemoApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(DemoApplication.class, args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
