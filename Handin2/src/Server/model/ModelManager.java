package Server.model;

import Server.model.LP;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ModelManager implements Model,PropertyChangeListener{
    private LPLibrary library;
    private PropertyChangeSupport property;

    public ModelManager(){
        this.library  = new LPLibrary();
        this.property = new PropertyChangeSupport(this);
    }

    @Override
    public ArrayList<LP> getAllLPs() {

        return library.getAllLPs();
    }

    @Override
    public LP getLP(String title, String artist) {

        return library.getLP(title,artist);
    }

    @Override
    public void addLP(LP lp) {
        library.add(lp);
        property.firePropertyChange("lpAdded", null, lp);
        Log.getInstance("server").addLog("LP added: " + lp);
    }

    @Override
    public void removeLP(LP lp) {
        lp.getState().remove(lp);
        property.firePropertyChange("lpFlagged", null, lp);
        Log.getInstance("server").addLog("LP removed: " + lp);
    }

    @Override
    public void remove(int index) {
        LP lp = library.getLP(index);
        library.remove(index);
        property.firePropertyChange("remove", null, lp);
        Log.getInstance("server").addLog("LP removed: " + lp);
    }

    @Override
    public void reserve(LP lp, String person) {
        String oldState = lp.getStateString();
        library.reserve(lp, person);
        property.firePropertyChange("lpReserved", oldState, lp.getStateString());
        Log.getInstance("server").addLog("LP reserved: " + lp);
    }

    @Override
    public void cancel(LP lp) {
        String oldState = lp.getStateString();
        library.cancel(lp);
        property.firePropertyChange("lpStateCanceled", oldState, lp.getStateString());
        Log.getInstance("server").addLog("LP canceled: " + lp);
    }

    @Override
    public void loan(LP lp, String person) {
        String oldState = lp.getStateString();
        library.loan(lp,person);
        property.firePropertyChange("lpLoaned", oldState, lp.getStateString());
        Log.getInstance("server").addLog("LP loaned: " + lp);
    }

    @Override
    public void returnLP(LP lp) {
        String oldState = lp.getStateString();
        library.returnLP(lp);
        property.firePropertyChange("lpReturned", oldState, lp.getStateString());
        Log.getInstance("server").addLog("LP returned: " + lp);

    }

    @Override
    public void flagForRemove(LP lp) {
        library.flagRemoveLP(lp);
        property.firePropertyChange("lpFlagged", false, true);
        Log.getInstance("server").addLog("LP flagged: " + lp);
    }

    @Override
    public void unflag(LP lp) {
        library.unflag(lp);
        property.firePropertyChange("lpUnFlagged", true, false);
        Log.getInstance("server").addLog("LP unflagged: " + lp);
    }

    @Override
    public void flagFoeRemove(int index) {
        library.flagRemoveLP(index);
        property.firePropertyChange("lpFlagged", false, true);
        Log.getInstance("server").addLog("LP flagged: " );
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

    }
}
