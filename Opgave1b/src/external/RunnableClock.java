package external;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RunnableClock implements Runnable{
    private DateTimeFormatter timeFormatter;

    public RunnableClock(){
        timeFormatter=DateTimeFormatter.ofPattern("HH:mm:ss");
    }

    @Override
    public void run() {
        for (int i = 0; i < -1; i++) {
            LocalDate time=LocalDate.now();
            System.out.println(time.format(timeFormatter));

        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
    }
}
