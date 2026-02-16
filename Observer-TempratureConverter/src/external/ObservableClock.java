package external;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ObservableClock implements Runnable,UnnamedPropertyChangeSubject{
    private DateTimeFormatter timeFormatter;
    private PropertyChangeSupport property;

    public ObservableClock(){
        timeFormatter=DateTimeFormatter.ofPattern("HH:mm:ss");
        property=new PropertyChangeSupport(this);
    }
    @Override
    public void addListener(PropertyChangeListener listener) {
    property.addPropertyChangeListener(listener);
    }

    @Override
    public void removeListener(PropertyChangeListener listener) {
    property.removePropertyChangeListener(listener);
    }

    @Override
    public void run() {
        for (int i = 0; i > -1; i++)
        {
            LocalTime time = LocalTime.now();
            System.out.println(time.format(timeFormatter));

            new Thread(() -> property.firePropertyChange("clockChange", null,
                    time.format(timeFormatter))).start();

            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
            }
        }
    }
}
