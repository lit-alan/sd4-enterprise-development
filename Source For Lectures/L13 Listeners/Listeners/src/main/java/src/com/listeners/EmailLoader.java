package src.com.listeners;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class EmailLoader implements ServletContextListener {

    //Static variable to hold the email address for global access
    private static String customerServiceEmail;

    public static String getCustomerServiceEmail() {
        return customerServiceEmail;
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Loading customer service email during application startup...");

        try {
            //Load the email file from the classpath
            ClassPathResource resource = new ClassPathResource("customer-email.txt");

            if (!resource.exists()) {
                throw new RuntimeException("The customer-email.txt file is missing in the classpath.");
            }

            //Read the email address from the file
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
                String email = reader.readLine();

                if (email == null || email.trim().isEmpty()) {
                    throw new IllegalStateException("The customer-email.txt file is empty.");
                }

                //Store the email address in the static variable
                customerServiceEmail = email.trim();
                System.out.println("Customer Service Email loaded successfully: " + customerServiceEmail);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load customer service email address", e);
        }
    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //nothing to clean up
    }
}
