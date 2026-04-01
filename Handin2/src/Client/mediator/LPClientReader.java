package Client.mediator;

import Client.model.LP;
import parser.ParserException;

import java.io.BufferedReader;
import java.io.IOException;

public class LPClientReader implements Runnable{
    private LPClient lpClient;
    private BufferedReader in;
    private boolean running;

    public LPClientReader(LPClient client,BufferedReader in){
        this.lpClient=client;
        this.in=in;
    }
    public void close() throws IOException {
        in.close();
    }

    @Override
    public void run() {
        while(true)
        {
            try
            {
                lpClient.receive(in.readLine());
            }
            catch (IOException | ParserException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}
