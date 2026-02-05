public class main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter=new Counter(10,15);

        CounterIncrementer c1=new CounterIncrementer(counter,200);
        CounterIncrementer c2=new CounterIncrementer(counter,200);
        CounterDecrementer c3=new CounterDecrementer(counter,200);
        CounterDecrementer c4=new CounterDecrementer(counter,200);

        Thread t1=new Thread(c1);
        Thread t2=new Thread(c2);
        Thread t3=new Thread(c3);
        Thread t4=new Thread(c4);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        }catch (InterruptedException e){

        }



        System.out.println(counter.getValue());











    }

}
