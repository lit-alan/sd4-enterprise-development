package src.com.schedulers;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class ReportGenerationTask {

    //Every day at 11PM
    @Scheduled(cron = "0 0 23 * * ?")
    public void generateDailyReports() {
        System.out.println("Generating daily reports...");
        //Could use IText library to generate a PDF
    }
}