package Server;

import Server.mediator.LPServer;
import Server.model.Model;
import Server.model.ModelManager;
import Server.model.UserSimulator;
import Server.view.ViewHandler;
import Server.viewmodel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class MyApplication extends Application
{
    public void start(Stage primaryStage) throws IOException {
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
        LPServer server = new LPServer(model);
        Thread serverThread=new Thread(server);
        serverThread.setDaemon(true);
        serverThread.start();

    }

}
