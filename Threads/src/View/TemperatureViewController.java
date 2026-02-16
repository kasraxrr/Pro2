package View;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.TemperatureModel;

public class TemperatureViewController {
    @FXML private TextField textInput;
    @FXML private Label labelOutput;
    @FXML private Label labelTimer;
    private Region root;
    private ViewHandler viewHandler;
    private TemperatureModel temperatureModel;

    public TemperatureViewController(){
    }
    public void init(ViewHandler viewHandler, TemperatureModel temperatureModel,Region root){
        this.viewHandler=viewHandler;
        this.temperatureModel=temperatureModel;
        this.root=root;

        RunnableClock runnableClock = new RunnableClock(this);
        Thread t1 = new Thread(runnableClock);
        t1.setDaemon(true);
        t1.start();
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
        if(textInput.getText() != null && Integer.parseInt(textInput.getText()) >= 0)
        {
            labelOutput.setText(textInput.getText()+" °F is "+temperatureModel.toCelsius(Double.parseDouble(textInput.getText()))+" °C");
        }
    }

    public void ToF(ActionEvent actionEvent) {
        if(textInput.getText() != null && Integer.parseInt(textInput.getText()) >= 0)
        {
            labelOutput.setText(textInput.getText()+" °C is "+temperatureModel.toFahrenheit(Double.parseDouble(textInput.getText()))+" °F");
        }
    }
    public void showTime(String timeString)
    {
        Platform.runLater(() ->     labelTimer.setText(timeString));
    }
}
