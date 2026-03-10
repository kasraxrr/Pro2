public class Counter {
    private long value;
    private static Counter instance;

    private Counter(){
        this.value=0;
    }
    public synchronized void incrementer(){
        value++;
    }
    public synchronized long getValue(){
        return value;
    }
    public static synchronized Counter getInstance()
    {
        if (instance==null){

                if (instance==null){
                    instance=new Counter();
                }

        }return instance;
    }
}
