public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        CounterIncrementer c1 = new CounterIncrementer(counter, 200000);
        CounterIncrementer c2 = new CounterIncrementer(counter, 200000);

        Thread t1 = new Thread(c1, "Incrementor1");
        Thread t2 = new Thread(c2, "Incrementor2");

        t1.start();
        t2.start();

        System.out.println(counter.getValue());
    }
}
