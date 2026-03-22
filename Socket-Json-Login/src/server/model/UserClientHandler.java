package server.model;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class UserClientHandler implements Runnable{
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private boolean running;
    private Gson parser;
    private String clientIp;
    private Model model;

    public UserClientHandler(Socket socket,Model model) throws IOException {
        this.socket=socket;
        this.model=model;
        this.in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out=new PrintWriter(socket.getOutputStream(),true);
        parser = new Gson();
        running = false;
        clientIp = socket.getInetAddress().getHostAddress();
    }

    @Override
    public void run(){
    try{
        this.running=true;
        UserPackage userPackage = parser.fromJson(in.readLine(), UserPackage.class);
        model.addUser(userPackage.getUser(), userPackage.getPassword());
        out.println("Success: you are now logged in");
        socket.close();
        running = false;
    }
    catch(Exception e){
        System.out.println(e.getMessage());

    }
    }

    public void close() throws IOException {
        this.running=false;
        socket.close();

    }


}
