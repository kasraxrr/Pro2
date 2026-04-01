package Server.mediator;

import Server.model.*;
import javafx.application.Platform;
import parser.ParserException;
import parser.XmlJsonParser;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class LPClientHandler implements PropertyChangeListener,Runnable {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private boolean running;
    private XmlJsonParser xmlJsonParser;
    private Model model;
    private String clientIp;

    public LPClientHandler(Socket socket, Model model) throws IOException {
        this.socket=socket;
        in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out=new PrintWriter(socket.getOutputStream(),true);
        xmlJsonParser=new XmlJsonParser();
        xmlJsonParser.registerPolymorphicAdapter(
                LPState.class, List.of(AvailableState.class, LoanedState.class, LoanedAndReservedState.class, ReservedState.class,RemovingState.class));
        this.model=model;
        clientIp = socket.getInetAddress().getHostAddress();
        model.addListener(this);
        System.out.println("Connection established with " + socket.getInetAddress()
                .getHostAddress());
        Log.getInstance("server").addLog("Client connected: " + socket.getInetAddress().getHostAddress());


    }

    public void close() throws IOException {
        socket.close();
    }

    @Override
    public void run() {
        try
        {
            while (true)
            {
                String messageIn = in.readLine();
                System.out.println(messageIn);
                LPPackage lpPackage = xmlJsonParser.fromJson(messageIn,
                        LPPackage.class);

                switch (lpPackage.getType())
                {
                    case "All":
                        LPListPackage lpListPackage = new LPListPackage(
                                "All", model.getAllLPs());
                        out.println(xmlJsonParser.toJson(lpListPackage,
                                LPListPackage.class, false));
                        break;
                    case "Get":
                        LP lp = model.getLP(lpPackage.getTitle(), lpPackage.getArtist());
                        if (lp == null)
                        {
                            LPPackage exercisePackageError = new LPPackage(
                                    "Error",
                                    "LP with the title " + lpPackage.getTitle()
                                            + " and artist "+ lpPackage.getArtist() +" is null");
                            out.println(xmlJsonParser.toJson(exercisePackageError,
                                    LPPackage.class, false));
                        }
                        else
                        {
                            LPPackage lpPackageServer = new LPPackage("Get",
                                    lp, lp.getTitle(), lp.getArtist(), null);
                            out.println(xmlJsonParser.toJson(lpPackageServer,
                                    LPPackage.class, false));
                        }
                        break;
                    case "Add":
                        model.addLP(lpPackage.getLP());
                        break;
                    case "Reserve":
                        model.reserve( lpPackage.getLP(),lpPackage.getName());
                        break;
                    case "Loan":
                        model.loan(lpPackage.getLP(),lpPackage.getName());
                        break;
                    case "Return":
                        model.returnLP(lpPackage.getLP());
                        break;
                    case "Cancel":
                        model.cancel(lpPackage.getLP());
                        break;
                    case "Remove":
                        model.removeLP(lpPackage.getLP());
                        break;
                }

            }
        }
        catch (IOException | ParserException e)
        {
            LPPackage error = new LPPackage("Error", e.getMessage());
            try
            {
                out.println(xmlJsonParser.toJson(error, false));
            }
            catch (ParserException ex)
            {
                System.out.println(ex.getMessage());
                Log.getInstance("errors").addLog("Error: " + e.getMessage());

            }
        }
    }

    @Override public void propertyChange(PropertyChangeEvent evt)
    {
        Platform.runLater(() -> {
            LP lp = (LP) evt.getNewValue();
            try
            {
                switch (evt.getPropertyName())
                {
                    case "add":
                        if (lp == null)
                        {
                            out.println(xmlJsonParser.toJson(
                                    new LPPackage("Error", "Couldn't add the exercise"),
                                    LPPackage.class, false));
                        }
                        else
                        {
                            out.println(xmlJsonParser.toJson(
                                    new LPPackage("Add", lp, null, null, null),
                                    LPPackage.class, false));
                        }
                        break;
                    case "reserve":
                        if (lp == null)
                        {
                            out.println(xmlJsonParser.toJson(
                                    new LPPackage("Error", "Couldn't reserve the exercise"),
                                    LPPackage.class, false));
                        }
                        else
                        {
                            out.println(xmlJsonParser.toJson(
                                    new LPPackage("Reserve", lp, null, null, lp.getState().getReservedBy()),
                                    LPPackage.class, false));
                        }
                        break;
                    case "loan":
                        if (lp == null)
                        {
                            out.println(xmlJsonParser.toJson(
                                    new LPPackage("Error", "Couldn't loan the exercise"),
                                    LPPackage.class, false));
                        }
                        else
                        {
                            out.println(xmlJsonParser.toJson(
                                    new LPPackage("Loan", lp, null, null, lp.getState().getLoanedTo()),
                                    LPPackage.class, false));
                        }
                        break;
                    case "return":
                        if (lp == null)
                        {
                            out.println(xmlJsonParser.toJson(
                                    new LPPackage("Error", "Couldn't return the exercise"),
                                    LPPackage.class, false));
                        }
                        else
                        {
                            out.println(xmlJsonParser.toJson(
                                    new LPPackage("Return", lp, null, null, null),
                                    LPPackage.class, false));
                        }
                        break;
                    case "cancel":
                        if (lp == null)
                        {
                            out.println(xmlJsonParser.toJson(
                                    new LPPackage("Error", "Couldn't cancel the exercise"),
                                    LPPackage.class, false));
                        }
                        else
                        {
                            out.println(xmlJsonParser.toJson(
                                    new LPPackage("Cancel", lp, null, null, null),
                                    LPPackage.class, false));
                        }
                        break;
                    case "remove":
                        if (lp == null)
                        {
                            out.println(xmlJsonParser.toJson(
                                    new LPPackage("Error", "Couldn't remove the exercise"),
                                    LPPackage.class, false));
                        }
                        else
                        {
                            System.out.println(lp);
                            out.println(xmlJsonParser.toJson(
                                    new LPPackage("Remove", lp, null, null, null),
                                    LPPackage.class, false));
                        }
                        break;
                }
            }
            catch (ParserException e)
            {
                System.out.println(e.getMessage());
                Log.getInstance("errors").addLog("Error: " + e.getMessage());

            }
        });
    }

}
