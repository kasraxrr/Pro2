public class BurgerBar {
    private int maxNumberOfBurgers;
    private int numberOfBurgers;

    public BurgerBar(int maxNumberOfBurgers){
        this.numberOfBurgers=100;
        this.maxNumberOfBurgers=maxNumberOfBurgers;
    }
    public synchronized void makeBurger(String employeeName){
        while (numberOfBurgers>=maxNumberOfBurgers){
            try {
                System.out.println(employeeName+"is waiting to create burger and have "+numberOfBurgers+" burgers");
                wait();
            }catch (InterruptedException e){

            }

        }
        numberOfBurgers++;
        System.out.println(Thread.currentThread().getName()+"made a burger and have "+numberOfBurgers+" burgers");
        notifyAll();
    }
    public synchronized void eatBurger(String who){
        while (numberOfBurgers<=0){
            try {
                System.out.println("cant sell any more now");
                wait();
            }catch (InterruptedException e){

            }

        }
        numberOfBurgers--;
        System.out.println(Thread.currentThread().getName()+" is ready to eat a burger and "+numberOfBurgers+" is left");
        notifyAll();
    }

    public synchronized int getNumberOfBurgers(){
        return numberOfBurgers;
    }
}
