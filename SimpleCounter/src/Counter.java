public class Counter {
    private long value;

    public Counter(){
        this.value=0;
    }
    public synchronized void incrementer(){
        value++;
    }
    public synchronized long getValue(){
        return value;
    }
}
