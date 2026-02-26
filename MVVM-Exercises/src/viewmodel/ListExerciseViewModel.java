package viewmodel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ListExerciseViewModel implements PropertyChangeListener{
    private ObservableList<SimpleExerciseViewModel> list;
    private ObjectProperty<SimpleExerciseViewModel> selectedExerciseProperty;
    private StringProperty errorProperty;
    private Model model;
    private ViewState viewState;

    public ListExerciseViewModel(Model model,ViewState viewState) {
        this.model = model;
        this.viewState = viewState;
        this.list = FXCollections.observableArrayList();
        this.selectedExerciseProperty = new SimpleObjectProperty<>();
        this.errorProperty=new SimpleStringProperty();
        model.addListener(this);
    }


















    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
