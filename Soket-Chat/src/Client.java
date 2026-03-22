import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        final int port=7;
        final String host="192.168.8.104";

        Socket socket=new Socket(host,port);

        Scanner scanner=new Scanner(System.in);

        BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out=new PrintWriter(socket.getOutputStream(),true);

        out.println("connect");

        while(true)
        {
            System.out.println("Write next line in chat (exit to stop): ");
            String request = scanner.nextLine();
            System.out.println("Client -> "+request);
            out.println(request);
            if(request.equals("exit"))
            {
                break;
            }
        }
        String reply = in.readLine();
        System.out.println("Server ->"+reply);
        socket.close();
    }
}
