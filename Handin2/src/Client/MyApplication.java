package Client;

import Client.model.Model;
import Client.model.ModelManager;
import Client.model.UserSimulator;
import Client.view.ViewHandler;
import Client.viewmodel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class MyApplication extends Application
{
    public void start(Stage primaryStage) throws IOException {
        Model model = new ModelManager();
        ViewModelFactory viewModelFactory = new ViewModelFactory(model);
        ViewHandler view = new ViewHandler(viewModelFactory);
        view.start(primaryStage);


    }
}
