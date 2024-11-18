package src.com.listeners;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import org.springframework.stereotype.Component;

@Component
public class AppLifecycleListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //This executes when the app starts
        System.out.println("Application is starting...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //This executes when the app shuts down
        System.out.println("Application is shutting down...");
    }
}

