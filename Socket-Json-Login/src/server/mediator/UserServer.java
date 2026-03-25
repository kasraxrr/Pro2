package server.mediator;

import server.model.Model;
import server.model.UserClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UserServer implements Runnable{

    private final static int PORT=2910;
    private boolean running;
    private ServerSocket welcomeSocket;
    private Model model;

    public UserServer(Model model){
        this.model=model;
        this.running=false;
        System.out.println("server started");
    }

    @Override
    public void run() {
        try {
            this.running=true;
            System.out.println("Waiting for a client");
            Socket socket=welcomeSocket.accept();
            UserClientHandler userClientHandler=new UserClientHandler(socket,model);
            Thread t=new Thread(userClientHandler);
            t.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void close() throws IOException {
        this.running=false;
        welcomeSocket.close();
    }
}
