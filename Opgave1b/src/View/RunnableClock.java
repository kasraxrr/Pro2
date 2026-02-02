package View;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RunnableClock implements Runnable{

    private DateTimeFormatter timeFormatter;
    private TemperatureViewController temperatureViewController;

    public RunnableClock(TemperatureViewController temperatureViewController){
        timeFormatter=DateTimeFormatter.ofPattern("HH:mm:ss");
        this.temperatureViewController=temperatureViewController;

    }

    @Override
    public void run() {
        for (int i = 0; i > -1; i++) {
            LocalTime time=LocalTime.now();
           String timeString=time.format(timeFormatter);
           temperatureViewController.showTime(timeString);
            System.out.println(timeString);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }

        }

    }
}
