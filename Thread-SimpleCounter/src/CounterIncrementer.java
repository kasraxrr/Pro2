public class CounterIncrementer implements Runnable{
    private Counter counter;
    private  int updates;

    public CounterIncrementer(Counter counter,int update){
        this.counter=counter;
        this.updates=update;
    }
    @Override
    public void run(){
        for (int i = 0; i < updates; i++) {
            counter.incrementer();
            System.out.println("updated to "+counter.getValue());
        }
    }
}
