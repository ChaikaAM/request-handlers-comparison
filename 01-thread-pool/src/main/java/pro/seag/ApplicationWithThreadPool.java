package pro.seag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationWithThreadPool {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationWithThreadPool.class, args);
    }

}
