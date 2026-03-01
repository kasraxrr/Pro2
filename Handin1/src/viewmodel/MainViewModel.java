package viewmodel;

import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextInputDialog;
import model.LP;
import model.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Optional;

public class MainViewModel implements PropertyChangeListener {
    private ObservableList<SimpleLPViewModel> list;
    private ObjectProperty<SimpleLPViewModel> selectedLPProperty;
    private StringProperty errorProperty;
    private Model model;
    private ViewState viewState;

    public MainViewModel(Model model, ViewState viewState)
    {
        this.model = model;
        this.viewState = viewState;

        list = FXCollections.observableArrayList();
        selectedLPProperty = new SimpleObjectProperty<>();

        errorProperty = new SimpleStringProperty();

        model.addListener(this);
    }

    public void clear()
    {
        list.clear();
    }
    public void loadFromModel()
    {
        Platform.runLater(() -> {
            ArrayList<LP> modelList = model.getAllLPs();
            list.clear();
            for (LP lp : modelList) {
                list.add(new SimpleLPViewModel(lp));
            }
        });
    }

    public void remove()
    {
        try
        {
            LP lp = model.getLP(selectedLPProperty.get().getTitleProperty().get(),
                    selectedLPProperty.get().getArtistProperty().get());
            if (selectedLPProperty.get().getFlaggedProperty().get()) {
                model.unflag(lp);
            }

            else if (lp.getStateString().equals("AvailableState"))
            {
                model.removeLP(lp);
            }else
            {
                model.flagForRemove(lp);
            }
        }
        catch (Exception e)
        {
            errorProperty.set(e.getMessage());
        }
    }

    public void loan()
    {
        try
        {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Loan");
            dialog.setContentText("Enter name of loaner:");
            Optional<String> result = dialog.showAndWait();
            result.ifPresent(s -> model.loan(
                    model.getLP(selectedLPProperty.get().getTitleProperty().get(),
                            selectedLPProperty.get().getArtistProperty().get()),s));
        }
        catch (Exception e)
        {
            errorProperty.set(e.getMessage());
        }
    }

    public void reserve()
    {
        try
        {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Reservation");
            dialog.setContentText("Enter name of reserver:");
            Optional<String> result = dialog.showAndWait();
            result.ifPresent(s -> model.reserve(
                    model.getLP(selectedLPProperty.get().getTitleProperty().get(),
                            selectedLPProperty.get().getArtistProperty().get()),s));
        }
        catch (Exception e)
        {
            errorProperty.set(e.getMessage());
        }
    }

    public void returnLP()
    {
        try
        {
            model.returnLP(model.getLP(selectedLPProperty.get().getTitleProperty().get(),
                    selectedLPProperty.get().getArtistProperty().get()));
        }
        catch (Exception e)
        {
            errorProperty.set(e.getMessage());
        }
    }

    public void cancel()
    {
        try
        {
            model.cancel(model.getLP(selectedLPProperty.get().getTitleProperty().get(),
                    selectedLPProperty.get().getArtistProperty().get()));
        }
        catch (Exception e)
        {
            errorProperty.set(e.getMessage());
        }
    }

    public ObservableList<SimpleLPViewModel> getAll()
    {
        return list;
    }

    public void setSelected(SimpleLPViewModel lpViewModel)
    {
        if(lpViewModel != null)
        {
            selectedLPProperty.set(lpViewModel);
            viewState.setTitle(lpViewModel.getTitleProperty().get());
            viewState.setArtist(lpViewModel.getArtistProperty().get());
        }else
        {
            selectedLPProperty.set(null);
            viewState.setTitle(null);
            viewState.setArtist(null);
        }
    }

    public StringProperty getErrorProperty()
    {
        return errorProperty;
    }

    private void removeSimpleLP(LP lp)
    {
        list.remove(new SimpleLPViewModel(lp));
    }

    private void addSimpleLP(LP lp)
    {
        list.add(new SimpleLPViewModel(lp));
    }

    @Override public void propertyChange(PropertyChangeEvent evt)
    {
        Platform.runLater(() -> {
            System.out.println("Received event from Model: " + evt.getPropertyName());
            switch(evt.getPropertyName())
            {
                case "lpRemoved":
                    removeSimpleLP((LP) evt.getNewValue());
                    break;
                case "lpAdded":
                    addSimpleLP((LP) evt.getNewValue());
                    break;
                case "lpLoaned", "lpReserved", "lpFlagged","lpUnFlagged", "lpReturned", "lpStateCanceled":
                    System.out.println("loading model");
                    loadFromModel();
                    break;
            }
        });
    }
























}
