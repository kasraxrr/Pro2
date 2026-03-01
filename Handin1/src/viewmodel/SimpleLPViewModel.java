package viewmodel;

import javafx.beans.property.*;
import model.LP;

public class SimpleLPViewModel
{
    private StringProperty titleProperty;
    private StringProperty artistProperty;
    private IntegerProperty yearProperty;
    private StringProperty statusProperty;
    private BooleanProperty flaggedProperty;

    public SimpleLPViewModel(LP lp)
    {
        titleProperty = new SimpleStringProperty(lp.getTitle());
        artistProperty = new SimpleStringProperty(lp.getArtist());
        yearProperty = new SimpleIntegerProperty(lp.getYear());
        statusProperty = new SimpleStringProperty(lp.getStateString());
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
}