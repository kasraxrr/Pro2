public class Counter {
    private long value;
    private long max;
    private long min;

    public Counter(long min,long max){
        this.value=0;
        this.min=min;
        this.max=max;
    }
    public synchronized void increment(){
        while (value>=max){
            try {
                System.out.println(value+Thread.currentThread().getName()+" is waiting");
                wait();

            }catch (InterruptedException e){

            }

        }
            value++;
        System.out.println(value+Thread.currentThread().getName()+" is done");
        notifyAll();

    }
    public synchronized void decrement() {
        while (value<=min){
            try {
                System.out.println(value+Thread.currentThread().getName()+" is waiting");
                wait();
            }catch (InterruptedException e){

            }
        }
            value--;
        System.out.println(value+Thread.currentThread().getName()+" is done");

        notifyAll();

    }
    public synchronized long getValue(){

            return value;

    }
}