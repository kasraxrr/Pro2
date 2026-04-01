package Server.mediator;

import Server.model.Log;
import Server.model.Model;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class LPServer implements Runnable{
    private final int PORT=6767;
    private boolean running;
    private ServerSocket welcomeSocket;
    private Model model;

    public LPServer(Model model) throws IOException {
        this.model=model;
        welcomeSocket=new ServerSocket(PORT);
        System.out.println("Server started on "+ InetAddress.getLocalHost().getHostAddress()+":"+PORT);
        Log.getInstance("server").addLog("Server started on port " + PORT);

    }
    public void close() throws IOException {
        welcomeSocket.close();
    }

    @Override
    public void run() {
        while (true){
            try {
                Socket socket=welcomeSocket.accept();
                System.out.println("Waiting on client...");
                LPClientHandler lpClientHandler=new LPClientHandler(socket,model);
                Thread t1=new Thread(lpClientHandler);
                t1.setDaemon(true);
                t1.start();
            }catch (IOException e){
                Log.getInstance("errors").addLog("Error: " + e.getMessage());
                throw new RuntimeException();

            }
        }

    }
}
