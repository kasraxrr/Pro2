import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        final int PORT = 2905;
        System.out.println("Starting Server...");

        ServerSocket welcomeSocket=new ServerSocket(PORT);

        while (true){
            System.out.println("Waiting for a client...");
            Socket socket = welcomeSocket.accept();

            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintWriter out=new PrintWriter(socket.getOutputStream(),true);

            String request = in.readLine(); // read line from client.
            System.out.println("Client> " + request);
            String reply = request.toUpperCase();
            System.out.println("Server> " + reply);
            out.println(reply);

        }
    }
}