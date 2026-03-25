package client.mediator;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class UserClient {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private Gson gson;


    public UserClient(String host,int ip) throws IOException {
        this.socket=new Socket(host,ip);
        in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out=new PrintWriter(socket.getOutputStream(),true);
        this.gson=new Gson();

    }
    public void disconnect() throws IOException {
        this.socket.close();
    }

    public void login(String userName,String password) throws IOException {
        User user=new User(userName,password);
        out.println(gson.toJson(user));
        String received=in.readLine();
        System.out.println(received);
    }
}
