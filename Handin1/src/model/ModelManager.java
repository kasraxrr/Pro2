package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ModelManager implements Model{
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
    }

    @Override
    public void removeLP(LP lp) {
        lp.getState().remove(lp);
        property.firePropertyChange("lpFlagged", null, lp);
    }

    @Override
    public void remove(int index) {
        LP lp = library.getLP(index);
        library.remove(index);
        property.firePropertyChange("remove", null, lp);
    }

    @Override
    public void reserve(LP lp, String person) {
        String oldState = lp.getStateString();
        library.reserve(lp, person);
        property.firePropertyChange("lpReserved", oldState, lp.getStateString());
    }

    @Override
    public void cancel(LP lp) {
        String oldState = lp.getStateString();
        library.cancel(lp);
        property.firePropertyChange("lpStateCanceled", oldState, lp.getStateString());
    }

    @Override
    public void loan(LP lp, String person) {
        String oldState = lp.getStateString();
        library.loan(lp,person);
        property.firePropertyChange("lpLoaned", oldState, lp.getStateString());
    }

    @Override
    public void returnLP(LP lp) {
        String oldState = lp.getStateString();
        library.returnLP(lp);
        property.firePropertyChange("lpReturned", oldState, lp.getStateString());

    }

    @Override
    public void flagForRemove(LP lp) {
        library.flagRemoveLP(lp);
        property.firePropertyChange("lpFlagged", false, true);
    }

    @Override
    public void unflag(LP lp) {
        library.unflag(lp);
        property.firePropertyChange("lpUnFlagged", true, false);
    }

    @Override
    public void flagFoeRemove(int index) {
        library.flagRemoveLP(index);
        property.firePropertyChange("lpFlagged", false, true);
    }


    @Override
    public void addListener(PropertyChangeListener listener) {
        property.addPropertyChangeListener(listener);
    }

    @Override
    public void removeListener(PropertyChangeListener listener) {
        property.removePropertyChangeListener(listener);
    }
}
