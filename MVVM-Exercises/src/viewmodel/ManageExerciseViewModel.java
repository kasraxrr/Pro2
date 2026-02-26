package viewmodel;

import javafx.beans.property.*;
import model.Model;

public class ManageExerciseViewModel {
    private Model model;
    private ViewState viewState;
    private StringProperty errorProperty;
    private StringProperty headerProperty;
    private ObjectProperty<Boolean> completedProperty;
    private StringProperty topicProperty;
    private IntegerProperty numberProperty;
    private IntegerProperty sessionProperty;
    private ObjectProperty<Boolean> editableProperty;

    public ManageExerciseViewModel(Model model, ViewState viewState){
        this.model=model;
        this.viewState=viewState;
        this.errorProperty=new SimpleStringProperty();
        this.headerProperty=new SimpleStringProperty();
        this.completedProperty=new SimpleObjectProperty<>();
        this.topicProperty=new SimpleStringProperty();
        this.numberProperty=new SimpleIntegerProperty();
        this.sessionProperty=new SimpleIntegerProperty();
        this.editableProperty=new SimpleObjectProperty<>();
    }
}
