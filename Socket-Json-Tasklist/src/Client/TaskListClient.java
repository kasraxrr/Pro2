package Client;

import Server.TaskListServer;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TaskListClient {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Scanner input;

    public TaskListClient(String host,int port) throws IOException {
        final int PORT = 2905;
        final String HOST = "192.168.8.104";
        this.socket=new Socket(host,port);
        this.input=new Scanner(System.in);

    }
    private void execute() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        out.println("connect");

        String reply = in.readLine();
        System.out.println("Server ->"+reply);

        System.out.println("Write a line to the server: ");
        String request = input.nextLine();
        System.out.println("Client -> "+request);
        out.println(request);

        reply = in.readLine();
        System.out.println("Server ->"+reply);

        System.out.println("Write a line to the server: ");
        String request2 = input.nextLine();
        System.out.println("Client -> "+request2);
        out.println(request2);

        String reply2 = in.readLine();
        System.out.println("Server -> "+reply2);

        socket.close();
    }

}
