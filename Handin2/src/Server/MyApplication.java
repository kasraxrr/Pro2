package Server;

import Server.model.Model;
import Server.model.ModelManager;
import Server.model.UserSimulator;
import Server.view.ViewHandler;
import Server.viewmodel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class MyApplication extends Application
{
    public void start(Stage primaryStage)
    {
        Model model = new ModelManager();
        ViewModelFactory viewModelFactory = new ViewModelFactory(model);
        ViewHandler view = new ViewHandler(viewModelFactory);
        UserSimulator simulator = new UserSimulator(model, "bob");
        UserSimulator simulator2 = new UserSimulator(model, "windy");
        Thread simThread = new Thread(simulator);
        Thread simThread2 = new Thread(simulator2);
        simThread.setDaemon(true);
        simThread2.setDaemon(true);
        simThread.start();
        simThread2.start();
        view.start(primaryStage);


    }
}
