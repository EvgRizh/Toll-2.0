package jdev;

import jdev.Service.GPSSimService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * Created by jenia on 01.03.22.
 */
@Configuration
@EnableScheduling
@PropertySource("classpath:/app.properties")
public class GPSContext {
    @Bean
    public GPSSimService gpsSimService() {
        return new GPSSimService();
    }

//    @Bean
//    public TaskScheduler poolScheduler() {
//        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
//        scheduler.setThreadNamePrefix("poolScheduler");
//        scheduler.setPoolSize(20);
//        return scheduler;
//    }
}
