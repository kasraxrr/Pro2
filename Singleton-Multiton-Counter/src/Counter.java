import java.util.HashMap;
import java.util.Map;

public class Counter {
    private long value;
    private static Map<String,Counter> map=new HashMap<>();

    private Counter(){
        this.value=0;
    }
    public synchronized void incrementer(){
        value++;
    }
    public synchronized long getValue(){
        return value;
    }

    public static synchronized Counter getInstance(String key)
    {
        Counter instance=map.get(key);
        if (instance==null){
            synchronized (map){
                instance=map.get(key);
                if (instance==null){
                    instance=new Counter();
                    map.put(key,instance);
                }
            }

        }return instance;
    }
}
