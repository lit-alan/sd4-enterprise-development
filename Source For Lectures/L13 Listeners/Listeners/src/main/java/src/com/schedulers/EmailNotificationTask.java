package src.com.schedulers;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class EmailNotificationTask {

    //Every day at 9:05AM
    @Scheduled(cron = "0 5 9 * * ?")
    public void sendDailyEmails() {
        System.out.println("Sending daily email notifications...");
        //Use JavaMail to send emails
    }
}


