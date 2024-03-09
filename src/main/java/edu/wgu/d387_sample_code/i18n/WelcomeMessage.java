package edu.wgu.d387_sample_code.i18n;
import org.springframework.core.io.ClassPathResource;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class WelcomeMessage {

    private final ArrayList<String> welcomeMessages = new ArrayList<>();

    private String message1;

    private String message2;

    public void setWelcomeMessages() {
        Properties properties  = new Properties();

        try {
            InputStream stream = new ClassPathResource("messages_en_CA.properties").getInputStream();
            properties.load(stream);
            message1 = properties.getProperty("message");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try {
            InputStream stream = new ClassPathResource("messages_fr_CA.properties").getInputStream();
            properties.load(stream);
            message2 = properties.getProperty("message");
        } catch (IOException e) {
            throw new RuntimeException(e);
            }
    }


    public String getMessage1(){
        return message1;
    }

    public String getMessage2(){
        return message2;
    }
}
