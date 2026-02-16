import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public interface UnnamedPropertyChangeSubject {
    public void addListener(PropertyChangeListener listener);
    public void removeListener(PropertyChangeListener listener);
}
