import java.beans.PropertyChangeSupport;

public class Bus implements UnnamedPropertyChangeSubject{
    private String info;
    private PropertyChangeSupport property;
    private Set<BusPassenger> passengers;

    public Bus(){
        property=new PropertyChangeSupport(this);
    }
    public void passengerGettingIn(BusPassenger p){

    }
}
