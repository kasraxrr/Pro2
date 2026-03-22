import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public static void main(String[] args) throws IOException {
        final int port=7;
        System.out.println("Starting server...");
        System.out.println("Serverip: "+ InetAddress.getLocalHost().getHostAddress());

        ServerSocket welcomeSocket=new ServerSocket(port);

        while (true){


            System.out.println("Waiting for client...");

            Socket socket=welcomeSocket.accept();

            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out=new PrintWriter(socket.getOutputStream(),true);



            String request = in.readLine();

            System.out.println("Client -> "+request);
            String reply = "NONO";
            if(request.equals("connect"))
            {
                reply = "Chat line?";
            }

            if(reply.equals("Chat line?"))
            {
                ArrayList<String> chat = new ArrayList<>();
                while(true)
                {
                    System.out.println("Server -> "+reply);
                    out.println(reply);

                    BufferedReader in2 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String request2 = in2.readLine();
                    System.out.println("Client -> "+request2);
                    if(request2.equals("exit"))
                    {
                        System.out.println(chat);
                        break;
                    }
                    chat.add(request2);
                }
            }
        }
    }
}
