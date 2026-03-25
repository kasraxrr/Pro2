package server.mediator;

import com.google.gson.Gson;
import server.model.*;
import server.model.UserPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class UserClientHandler implements Runnable{

    private Model model;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private boolean running;
    private Gson gson;
    private String clientIp;

    public UserClientHandler(Socket socket,Model model) throws IOException {
        this.model=model;
        this.socket=socket;
        in= new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out=new PrintWriter(socket.getOutputStream(),true);
        this.gson=new Gson();
        this.running=false;
        clientIp=socket.getInetAddress().getHostAddress();
    }

    @Override
    public void run() {
        try {
            this.running=true;
            UserPackage userPackage=gson.fromJson(in.readLine(),UserPackage.class);
            model.addUser(new UserName(userPackage.getUser()), new Password(userPackage.getPassword()));
            out.println("Success: you are now logged in");
            socket.close();
            running = false;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void close() throws IOException {
        this.running=false;
        socket.close();
    }
}
