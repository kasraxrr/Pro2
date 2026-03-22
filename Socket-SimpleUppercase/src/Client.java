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

        Scanner scanner=new Scanner(System.in);

        Socket socket=new Socket(host,port);

        BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));

        PrintWriter out=new PrintWriter(socket.getOutputStream());

        System.out.println("send your first message to server");
        String req=scanner.nextLine();
        out.println(req);

        System.out.println("server said : "+in.readLine());

        System.out.println("send your request");
        String req2=scanner.nextLine();
        out.println(req2);
        System.out.println("server said : "+in.readLine());
        socket.close();
    }
}
