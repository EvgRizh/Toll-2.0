package jdev;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by jenia on 01.03.22.
 */
public class GPSMain {
    public static void main(String... args) throws InterruptedException {
        ApplicationContext context = new AnnotationConfigApplicationContext(GPSContext.class);
    }
}
