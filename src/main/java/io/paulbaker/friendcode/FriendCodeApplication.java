package io.paulbaker.friendcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class FriendCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(FriendCodeApplication.class, args);
    }
}
