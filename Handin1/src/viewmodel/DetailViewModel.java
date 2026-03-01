package viewmodel;

import javafx.beans.property.*;
import javafx.scene.layout.Region;
import model.LP;
import model.Model;

public class DetailViewModel {

    private StringProperty titleFieldProperty;
    private StringProperty artistFieldProperty;
    private IntegerProperty yearFieldProperty;
    private StringProperty reservedByProperty;
    private StringProperty loanedToProperty;
    private StringProperty stateProperty;
    private StringProperty errorProperty;
    private Model model;
    private ViewState viewModelState;
    private BooleanProperty addingProperty;

    public DetailViewModel(Model model, ViewState viewModelState)
    {
        this.model = model;
        this.viewModelState = viewModelState;

        errorProperty = new SimpleStringProperty();
        titleFieldProperty = new SimpleStringProperty();
        artistFieldProperty = new SimpleStringProperty();
        yearFieldProperty = new SimpleIntegerProperty();
        reservedByProperty = new SimpleStringProperty("none");
        loanedToProperty = new SimpleStringProperty("none");
        stateProperty = new SimpleStringProperty();
        addingProperty = new SimpleBooleanProperty(true);
    }
    public void reset()
    {
        errorProperty.set("");
        if(viewModelState.getTitle() != null)
        {
            addingProperty.set(false);

            LP lp = model.getLP(viewModelState.getTitle(), viewModelState.getArtist());
            titleFieldProperty.set(lp.getTitle());
            artistFieldProperty.set(lp.getArtist());
            yearFieldProperty.set(lp.getYear());
            String reserverName = "none";
            if(lp.getState().getReservedBy() != null)
            {
                reserverName = lp.getState().getReservedBy();
            }
            String loanerName = "none";
            if(lp.getState().getLoanedTo() != null)
            {
                loanerName = lp.getState().getLoanedTo();
            }
            reservedByProperty.set(reserverName);
            loanedToProperty.set(loanerName);
            stateProperty.set(lp.getStateString());
        }else
        {
            addingProperty.set(true);

            titleFieldProperty.set("");
            artistFieldProperty.set("");
            yearFieldProperty.set(0);
            reservedByProperty.set("none");
            loanedToProperty.set("none");
            stateProperty.set("");
        }
    }

    public StringProperty getTitleFieldProperty()
    {
        return titleFieldProperty;
    }

    public StringProperty getArtistFieldProperty()
    {
        return artistFieldProperty;
    }

    public IntegerProperty getYearFieldProperty()
    {
        return yearFieldProperty;
    }

    public StringProperty getReserverNameProperty()
    {
        return reservedByProperty;
    }

    public StringProperty getLoanerNameProperty()
    {
        return loanedToProperty;
    }

    public StringProperty getStateProperty()
    {
        return stateProperty;
    }

    public StringProperty getErrorProperty()
    {
        return errorProperty;
    }

    public BooleanProperty getAddingProperty()
    {
        return addingProperty;
    }

    public boolean submit()
    {
        try
        {
            model.addLP(new LP(titleFieldProperty.get(), artistFieldProperty.get(), yearFieldProperty.get()));
            return true;
        }
        catch(Exception e)
        {
            errorProperty.set(e.getMessage());
            return false;
        }
    }
















}
