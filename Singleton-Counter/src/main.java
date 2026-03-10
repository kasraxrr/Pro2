public class main {
    public static void main(String[] args) {
        Counter counter=Counter.getInstance();
        Counter counter2=Counter.getInstance();

        CounterIncrementer counterIncrementer=new CounterIncrementer(counter,200000);
        CounterIncrementer counterIncrementer2=new CounterIncrementer(counter2,200000);

        Thread t1=new Thread(counterIncrementer);
        Thread t2=new Thread(counterIncrementer2);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }catch (InterruptedException e){

        }


        System.out.println(counter == counter2);
        System.out.println(counter.getValue());
        System.out.println(counter2.getValue());

    }
}
