package Server.model;

import org.w3c.dom.css.Counter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Log {
    private ArrayList<LogLine> logLines;
    private static Map<String, Log> allLogs = new HashMap<>();

    private Log(){
        this.logLines=new ArrayList<>();
    }

    public static Log getInstance(String key){
        Log log = allLogs.get(key);
        if(log == null)
        {

            synchronized (allLogs)
            {
                log = allLogs.get(key);
                if(log == null)
                {
                    log = new Log();
                    allLogs.put(key, log);
                }
            }
        }
        return log;
    }

    public void addLog(String text)
    {
        LogLine logLine = new LogLine(text);
        logLines.add(logLine);
        addToFile(logLine);
    }

    public ArrayList<LogLine> getAll()
    {
        return logLines;
    }

    @Override
    public String toString()
    {
        return logLines.toString();
    }

    private void addToFile(LogLine log)
    {
        if (log == null)
        {
            return;
        }
        BufferedWriter out = null;
        try
        {
            String filename = "Log-"
                    + log.getTime().getSortableDate() + ".txt";
            out = new BufferedWriter(new FileWriter(filename, true));
            out.write(log + "\n");
        }
        catch (Exception e) {e.printStackTrace();}
        finally
        {
            try
            {
                out.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }



}
