import View.ViewHandler;
import javafx.application.Application;
import javafx.stage.Stage;
import model.TemperatureModelManager;


public class MyApplication extends Application
{
    public void start(Stage primaryStage)
    {
        ViewHandler view = new ViewHandler(new TemperatureModelManager());
        view.start(primaryStage);
    }
}