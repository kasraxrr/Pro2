package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;

public class Server {

    public static void main(String[] args) throws IOException
    {
        final int PORT = 2905;
        System.out.println("Starting server...");
        System.out.println("Serverip: "+ InetAddress.getLocalHost().getHostAddress());

        TaskListServer taskListServer = new TaskListServer(new TaskList(), PORT);
    }

}
