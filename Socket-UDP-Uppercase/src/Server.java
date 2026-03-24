import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Arrays;

public class Server {
    final static int port=7;

    public static void main(String[] args) throws IOException {
        DatagramSocket serverSocket =new DatagramSocket(port);

        while (true){
            System.out.println("Wating for requests...");

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData,
                    receiveData.length);

            serverSocket.receive(receivePacket);
            String sentence = new String(receivePacket.getData()).trim();

            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            System.out.println("Client> " + sentence);
            String capitalizedSentence = sentence.toUpperCase();
            System.out.println("Server> " + capitalizedSentence);
            byte[] sendData = new byte[1024];
            sendData = capitalizedSentence.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData,
                    sendData.length, IPAddress, port);

            serverSocket.send(sendPacket);
        }

    }

}
