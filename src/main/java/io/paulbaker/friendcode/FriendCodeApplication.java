package io.paulbaker.friendcode;

import org.apache.commons.lang3.SystemUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

@SpringBootApplication
@EnableJpaRepositories
public class FriendCodeApplication {

    public static void main(String[] args) throws IOException, URISyntaxException {
        // Starts the actual app
        ConfigurableApplicationContext context = SpringApplication.run(FriendCodeApplication.class, args);
        // For convenience, starts a browser if we can detect the correct way to launch it.
        // You would never include this on your final application or production environment.
        String port = context.getEnvironment().getProperty("local.server.port");
        String localUrl = "http://localhost:" + port + "/product/admin";
        URL url = new URL(localUrl);
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().browse(url.toURI());
        } else {
            Runtime runtime = Runtime.getRuntime();
            String[] commandArray = null;
            if (SystemUtils.IS_OS_WINDOWS) {
                commandArray = new String[]{"start", localUrl};
            } else if (SystemUtils.IS_OS_MAC) {
                commandArray = new String[]{"open", localUrl};
            } else if (SystemUtils.IS_OS_LINUX) {
                commandArray = new String[]{"xdg-open", localUrl};
            }
            // Launch if we detected the proper command.
            if (commandArray != null) {
                runtime.exec(commandArray);
            } else {
                System.err.println("Browse to: " + localUrl);
            }
        }
    }
}
