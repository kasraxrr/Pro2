import java.time.LocalTime;

public class Log {
    private static Log instance;

    private Log(){
        instance=new Log();
    }

    public static Log getInstance()
    {
        if (instance == null)
        {
            synchronized (Log.class)
            {
                if (instance == null)
                {
                    instance = new Log();
                }
            }
        }
        return instance;
    }

    public void log(String message){

        System.out.println(LocalTime.now() + " | " + message);
    }
}
