public class CounterDecrementer implements Runnable{

    private int update;
    private Counter counter;

    public CounterDecrementer(Counter counter ,int updates){
        this.update=updates;
        this.counter=counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < update; i++) {
            counter.decrement();
        }
        System.out.println(Thread.currentThread().getName()+" "+counter
                .getValue());

    }
}
