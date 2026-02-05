public class CounterIncrementer implements Runnable{
    private int update;
    private Counter counter;

    public CounterIncrementer(Counter counter,int update){
        this.counter=counter;
        this.update=update;
    }
    @Override
    public void run(){
        for (int i = 0; i < update; i++) {
            counter.increment();
        }
        System.out.println(Thread.currentThread().getName()+" "+counter
                .getValue());

    }
}
