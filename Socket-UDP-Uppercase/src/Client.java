import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        final int port=7;
        final String host="192.168.8.104";

        Scanner scanner=new Scanner(System.in);

        DatagramSocket clientSocket = new DatagramSocket();

        InetAddress IPAddress = InetAddress.getByName(host);
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];


        System.out.print("Write a line for the server: ");
        String sentence = scanner.nextLine();
        System.out.println("Client> " + sentence);
        sendData = sentence.getBytes();
// Create datagram with data-to-send, length, IP addr, port
        DatagramPacket sendPacket = new DatagramPacket(sendData,
                sendData.length,IPAddress, port);
// Send datagram to server
        clientSocket.send(sendPacket);
// Read datagram from server.
        DatagramPacket receivePacket = new DatagramPacket(receiveData,
                receiveData.length);
        clientSocket.receive(receivePacket);
        String modifiedStc = new String(receivePacket.getData()).trim();
        System.out.println("Server> " + modifiedStc);
// Close connection.
        clientSocket.close();

    }
}
