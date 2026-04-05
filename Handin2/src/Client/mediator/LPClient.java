package Client.mediator;

import Client.model.*;
import parser.ParserException;
import parser.XmlJsonParser;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LPClient implements Model {
    private Model model;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private XmlJsonParser xmlJsonParser;
    private LPListPackage receivedListPackage;
    private ArrayList<LPPackage> receivedLPPackage;
    private boolean waiting;
    private PropertyChangeSupport property;

    public LPClient(Model model,String host,int port) throws IOException {
        this.socket=new Socket(host,port);
        this.model=model;
        in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out=new PrintWriter(socket.getOutputStream(),true);
        this.xmlJsonParser=new XmlJsonParser();
        xmlJsonParser.registerPolymorphicAdapter(
                LPState.class, List.of(AvailableState.class, LoanedState.class, LoanedAndReservedState.class, ReservedState.class,RemovingState.class));

        receivedListPackage=null;
        receivedLPPackage=new ArrayList<>();
        this.property=new PropertyChangeSupport(this);
        this.waiting=false;

        LPClientReader lpClientReader = new LPClientReader(this, in);
        Thread thread = new Thread(lpClientReader);
        thread.setDaemon(true);
        thread.start();

        System.out.println("Client connected");

    }
    public void disconnect() throws IOException {
        socket.close();
    }

    public synchronized void receive(String replyString) throws ParserException
    {
        System.out.println("Client received "+replyString);
        LPPackage lpPackage = xmlJsonParser.fromJson(replyString, LPPackage.class);

        if(waiting && xmlJsonParser.fromJson(replyString, Map.class).get("type").equals("All"))
        {
            receivedListPackage = xmlJsonParser.fromJson(replyString, LPListPackage.class);
            notifyAll();
        }
        else if(waiting)
        {
            receivedLPPackage.add(lpPackage);
            notifyAll();
        }else
        {
            property.firePropertyChange(lpPackage.getType(), lpPackage.getName(), lpPackage.getLP());
        }
    }


    @Override
    public synchronized ArrayList<LP> getAllLPs() {
        try {

            String jsonMessage = xmlJsonParser.toJson(new LPPackage("All", null, null, null, null), false);


            out.println(jsonMessage);


            while (receivedListPackage == null) {
                waiting = true;
                wait();
            }


            ArrayList<LP> lpArrayList = receivedListPackage.getLps();
            waiting = false;
            receivedListPackage = null;
            return lpArrayList;
        }
        catch (Exception e) {
            System.out.println("CRASH IN GET ALL LPS: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }


    @Override
    public synchronized LP getLP(String title, String artist) {
        try
        {
            out.println(xmlJsonParser.toJson(new LPPackage("Get", null, title, artist, null), false));
            while(receivedLPPackage.isEmpty())
            {
                waiting = true;
                wait();
            }
            waiting = false;
            for (int i = 0; i < receivedLPPackage.size(); i++)
            {
                if(receivedLPPackage.get(i).getTitle().equals(title) && receivedLPPackage.get(i).getArtist().equals(artist))
                {
                    if(receivedLPPackage.get(i).getError() == null)
                    {
                        LP lp = receivedLPPackage.get(i).getLP();
                        receivedLPPackage.remove(i);
                        return lp;
                    }else
                    {
                        throw new Exception(receivedLPPackage.get(i).getError());
                    }
                }
            }
            return null;
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public synchronized void addLP(LP lp) {
        try
        {
            out.println(xmlJsonParser.toJson(new LPPackage("Add", lp, null, null, null), false));
        }
        catch (ParserException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public synchronized void removeLP(LP lp) {
        System.out.println("remove "+ lp);
        try
        {
            out.println(xmlJsonParser.toJson(new LPPackage("Remove", lp, null, null, null), false));
            while(receivedLPPackage.isEmpty())
            {
                waiting = true;
                wait();
            }
            waiting = false;
            for (int i = 0; i < receivedLPPackage.size(); i++)
            {
                if(receivedLPPackage.get(i).getLP().equals(lp))
                {
                    if(receivedLPPackage.get(i).getError() == null)
                    {
                        receivedLPPackage.remove(i);
                    }else
                    {
                        throw new Exception(receivedLPPackage.get(i).getError());
                    }
                }
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void reserve(LP lp, String person) {
        try{
            out.println(xmlJsonParser.toJson(new LPPackage("reserve",lp,null,null,person),false));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void cancel(LP lp) {
        try
        {
            out.println(xmlJsonParser.toJson(new LPPackage("Cancel", lp, null, null, null), false));
        }
        catch (ParserException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void loan(LP lp, String person) {
    try {
        out.println(xmlJsonParser.toJson(new LPPackage("loan",lp,null,null,person),false));
    }catch (Exception e){
        System.out.println(e.getMessage());
    }
    }

    @Override
    public void returnLP(LP lp) {
        try
        {
            out.println(xmlJsonParser.toJson(new LPPackage("Return", lp, null, null, null), false));
        }
        catch (ParserException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void flagForRemove(LP lp) {

    }

    @Override
    public void unflag(LP lp) {

    }

    @Override
    public void flagFoeRemove(int index) {

    }

    @Override
    public void addListener(PropertyChangeListener listener) {
        property.addPropertyChangeListener(listener);

    }

    @Override
    public void removeListener(PropertyChangeListener listener) {
    property.removePropertyChangeListener(listener);
    }
}
