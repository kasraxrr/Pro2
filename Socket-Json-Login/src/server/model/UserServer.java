package server.model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UserServer implements Runnable{

    private static final int PORT=2910;
    private boolean running;
    private ServerSocket welcomeSocket;
    private Model model;

    public UserServer(Model model) throws IOException {
        this.model=model;
        this.running=false;
        this.welcomeSocket=new ServerSocket(PORT);
    }

    @Override
    public void run() {
        while(true)
        {
            try
            {
                System.out.println("Waiting on client...");
                Socket socket = welcomeSocket.accept();
                UserClientHandler userClientHandler = new UserClientHandler(socket, model);
                Thread t1 = new Thread(userClientHandler, "userClientHandler");
                t1.start();
            }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}
