public class main {
    public static void main(String[] args) {
        Counter counter=new Counter();

        CounterIncrementer counterIncrementer=new CounterIncrementer(counter,200000);

        Thread t1=new Thread(counterIncrementer);
        Thread t2=new Thread(counterIncrementer);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }catch (InterruptedException e){

        }



    }
}
