import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server {
    final static int port=7;

    public static void main(String[] args) throws IOException {
        ServerSocket welcome =new ServerSocket(port);

        while (true){
            System.out.println("Wating for requests...");
            Socket socket=welcome.accept();
            System.out.println(Arrays.toString(socket.getLocalAddress().getAddress()));
            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out=new PrintWriter(socket.getOutputStream());
            String req=in.readLine();
            out.println("welcome to my Uppercase converter");
            String question=in.readLine();
            out.println("here is your uppercase : "+question.toUpperCase());
        }

    }

}
