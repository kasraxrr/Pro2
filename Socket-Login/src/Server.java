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

            String request = in.readLine();
            if (!request.equals("connect")){
                out.println("Disconnected");
                socket.close();
                System.out.println("client disconnected");
            }else {

                String reply = "Username?";
                out.println(reply);
                String request2 = in.readLine();
                System.out.println("Username = "+request2);
                String reply2 = "Password?";
                out.println(reply2);
                String request3 = in.readLine();
                System.out.println("Password = "+request3);
                String reply3 = "Approved";
                out.println(reply3);

            }
        }
    }
}