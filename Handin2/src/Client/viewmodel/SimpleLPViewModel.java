package Client.viewmodel;

import javafx.beans.property.*;
import model.LP;

public class SimpleLPViewModel
{
    private StringProperty titleProperty;
    private StringProperty artistProperty;
    private IntegerProperty yearProperty;
    private StringProperty statusProperty;
    private StringProperty reservedByProperty;
    private StringProperty loanedToProperty;
    private BooleanProperty flaggedProperty;

    public SimpleLPViewModel(LP lp)
    {
        titleProperty = new SimpleStringProperty(lp.getTitle());
        artistProperty = new SimpleStringProperty(lp.getArtist());
        yearProperty = new SimpleIntegerProperty(lp.getYear());
        statusProperty = new SimpleStringProperty(lp.getStateString());
        reservedByProperty = new SimpleStringProperty(lp.getState().getReservedBy());
        loanedToProperty = new SimpleStringProperty(lp.getState().getLoanedTo());
        flaggedProperty = new SimpleBooleanProperty(lp.getState().getFlag());
    }

    public StringProperty getTitleProperty()
    {
        return titleProperty;
    }

    public StringProperty getArtistProperty()
    {
        return artistProperty;
    }

    public StringProperty getLoanedToProperty() {
        return loanedToProperty;
    }

    public StringProperty getReservedByProperty() {
        return reservedByProperty;
    }

    public IntegerProperty getYearProperty()
    {
        return yearProperty;
    }

    public StringProperty getStateProperty()
    {
        return statusProperty;
    }

    public BooleanProperty getFlaggedProperty()
    {
        return flaggedProperty;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SimpleLPViewModel other = (SimpleLPViewModel) obj;
        return titleProperty.get().equals(other.titleProperty.get()) &&
                artistProperty.get().equals(other.artistProperty.get());
    }
}