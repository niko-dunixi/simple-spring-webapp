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
        ConfigurableApplicationContext context = SpringApplication.run(FriendCodeApplication.class, args);

        String port = context.getEnvironment().getProperty("local.server.port");
        String localUrl = "http://localhost:" + port;
        URL url = new URL(localUrl);
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().browse(url.toURI());
        } else {
            Runtime runtime = Runtime.getRuntime();
            if (SystemUtils.IS_OS_WINDOWS) {
                runtime.exec(new String[]{"start", localUrl});
            } else if (SystemUtils.IS_OS_MAC) {
                runtime.exec(new String[]{"open", localUrl});
            } else if (SystemUtils.IS_OS_LINUX) {
                runtime.exec(new String[]{"xdg-open", localUrl});
            } else {
                System.err.println("Browse to: " + localUrl);
            }
        }
    }
}
