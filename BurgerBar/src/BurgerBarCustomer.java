public class BurgerBarCustomer implements Runnable{
    private int burgersToEat;
    private String name;
    private BurgerBar burgerBar;

    public BurgerBarCustomer(String name,BurgerBar burgerBar,int burgersToEat) {
        this.name = name;
        this.burgerBar = burgerBar;
        this.burgersToEat = burgersToEat;
    }


    @Override
    public void run(){
        while (true){
            burgerBar.eatBurger(name);
            try {
                Thread.sleep(4000);
            }catch (InterruptedException e){

            }
        }
    }
}


