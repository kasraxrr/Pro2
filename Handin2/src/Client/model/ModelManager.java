package Client.model;

import Client.mediator.LPClient;
import Client.model.LP;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.util.ArrayList;

public class ModelManager implements Model , PropertyChangeListener{
    private LPLibrary library;
    private PropertyChangeSupport property;
    private final static String HOST = "192.168.4.108";
    private final static int PORT=8080;
    private LPClient lpClient;


    public ModelManager() throws IOException {
        this.library  = new LPLibrary();
        this.property = new PropertyChangeSupport(this);
        this.lpClient = new LPClient(this, HOST, PORT);

        lpClient.addListener(this);
    }

    @Override
    public ArrayList<LP> getAllLPs() {

        return lpClient.getAllLPs();
    }

    @Override
    public LP getLP(String title, String artist) {

        return lpClient.getLP(title,artist);
    }

    @Override
    public void addLP(LP lp) {
        lpClient.addLP(lp);
    }

    @Override
    public void removeLP(LP lp) {
        lpClient.removeLP(lp);

    }

    @Override
    public void remove(int index) {
        lpClient.remove(index);

    }

    @Override
    public void reserve(LP lp, String person) {
        lpClient.reserve(lp, person);

    }

    @Override
    public void cancel(LP lp) {

        lpClient.cancel(lp);

    }

    @Override
    public void loan(LP lp, String person) {
        lpClient.loan(lp,person);

    }

    @Override
    public void returnLP(LP lp) {
        lpClient.returnLP(lp);


    }

    @Override
    public void flagForRemove(LP lp) {
        lpClient.flagForRemove(lp);

    }

    @Override
    public void unflag(LP lp) {
        lpClient.unflag(lp);

    }

    @Override
    public void flagFoeRemove(int index) {
        lpClient.flagFoeRemove(index);

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
    public void propertyChange(PropertyChangeEvent evt) {
        switch(evt.getPropertyName())
        {
            case "Add":
                property.firePropertyChange("add", null, evt.getNewValue());
                break;
            case "Remove":
                property.firePropertyChange("remove", null, evt.getNewValue());
                break;
            case "Loan":
                property.firePropertyChange("loan", evt.getOldValue(), evt.getNewValue());
                break;
            case "Reserve":
                property.firePropertyChange("reserve", evt.getOldValue(), evt.getNewValue());
                break;
            case "Cancel":
                property.firePropertyChange("cancel", null, evt.getNewValue());
                break;
            case "Return":
                property.firePropertyChange("return", null, evt.getNewValue());
                break;
            case "Flag":
                property.firePropertyChange("flag", null, evt.getNewValue());
                break;
        }
    }
}
