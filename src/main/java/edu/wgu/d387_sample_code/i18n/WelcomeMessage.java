package edu.wgu.d387_sample_code.i18n;
import org.springframework.core.io.ClassPathResource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class WelcomeMessage {
    static ExecutorService messageExecutor = newFixedThreadPool(2);

    private String[] welcomeMessages = new String[2];


    public String[] getWelcomeMessage() {
        Properties properties  = new Properties();

        messageExecutor.execute(() -> {
            try {
                InputStream stream = new ClassPathResource("messages_en_CA.properties").getInputStream();
                properties.load(stream);
                welcomeMessages[0] = properties.getProperty("message");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        messageExecutor.execute(() -> {
            try {
                InputStream stream = new ClassPathResource("messages_fr_CA.properties").getInputStream();
                properties.load(stream);
                welcomeMessages[1] = properties.getProperty("message");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        messageExecutor.shutdown();
        return welcomeMessages;

    }
}
