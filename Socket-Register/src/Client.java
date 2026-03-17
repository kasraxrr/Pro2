import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException, UnknownHostException {
        final int Port=5678;
        final String Host="10.154.218.65";

        Scanner input=new Scanner(System.in);

        Socket socket=new Socket(Host,Port);

        BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));

        PrintWriter out=new PrintWriter(socket.getOutputStream(),true);

        System.out.print("Write a line for the server: ");
        String request = input.nextLine();
        System.out.println("Client> " + request);
        out.println(request);
        String reply = in.readLine();
        System.out.println("Server> " + reply);
        System.out.print("Write a line for the server: ");
        String request2 = input.nextLine();
        out.println(request2);
        socket.close();




    }
}
