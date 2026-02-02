package View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import model.TemperatureModel;

import java.awt.*;

public class TemperatureViewController {
    @FXML private TextField textInput;
    @FXML private Label labelTimer;
    @FXML private Label labelOutput;
    private Region root;
    private ViewHandler viewHandler;
    private TemperatureModel temperatureModel;

    public TemperatureViewController(){
    }
    public void init(ViewHandler viewHandler, TemperatureModel temperatureModel,Region root){
        this.viewHandler=viewHandler;
        this.temperatureModel=temperatureModel;
        this.root=root;
    }
    public void reset(){
        labelTimer.setText("");
        labelOutput.setText("");
         textInput.setText("");
    }
    public Region getRoot(){
        return root;
    }

    public void ToC(ActionEvent actionEvent) {
        double cel=(double)textInput.getInputContext()/33.8;
    }

    public void ToF(ActionEvent actionEvent) {
    }
}
