public class Counter {
    private long value;

    public Counter(){
        this.value=0;
    }
    public void increment(){
        synchronized (this){
            value++;
        }

    }
    public long getValue(){
        synchronized (this){
            return value;
        }

    }

}
