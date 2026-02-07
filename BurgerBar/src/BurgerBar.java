public class BurgerBar {
    private int maxNumberOfBurgers;
    private int numberOfBurgers;

    public BurgerBar(int maxNumberOfBurgers){
        this.numberOfBurgers=0;
        this.maxNumberOfBurgers=maxNumberOfBurgers;
    }
    public synchronized void makeBurger(String employeeName){
        while (numberOfBurgers>=maxNumberOfBurgers){
            try {
                System.out.println("cant make any more now");
                wait();
            }catch (InterruptedException e){

            }

        }
        numberOfBurgers++;
        System.out.println(Thread.currentThread().getName()+"made a burger and have "+numberOfBurgers+" burgers");
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
    }

    public synchronized int getNumberOfBurgers(){
        return numberOfBurgers;
    }
}
