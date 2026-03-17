import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        final int PORT=5678;
        final String HOST="10.154.210.90";

        Scanner input=new Scanner(System.in);

        Socket socket=new Socket(HOST,PORT);

        BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));

        PrintWriter out=new PrintWriter(socket.getOutputStream(),true);


        String request = "connect";
        System.out.println("Client> " + request);
        out.println(request);
        String reply = in.readLine();
        System.out.println("Server> " + reply);
        String request2 = input.nextLine();
        out.println(request2);
        String reply2 = in.readLine();
        System.out.println("Server> " + reply2);
        String request3 = input.nextLine();
        out.println(request3);
        String reply4 = in.readLine();
        System.out.println("Server> " + reply4);


        socket.close();

    }
}
