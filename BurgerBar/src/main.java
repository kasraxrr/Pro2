public class main
{
    public static void main(String[] args) {

        BurgerBar burgerBar=new BurgerBar(100);
        BurgerBarEmployee e1=new BurgerBarEmployee("Devin",burgerBar);
        BurgerBarEmployee e2=new BurgerBarEmployee("Victor",burgerBar);
        BurgerBarCustomer c1=new BurgerBarCustomer("1",burgerBar,1);
        BurgerBarCustomer c2=new BurgerBarCustomer("2",burgerBar,2);
        BurgerBarCustomer c3=new BurgerBarCustomer("3",burgerBar,3);
        BurgerBarCustomer c4=new BurgerBarCustomer("4",burgerBar,4);
        BurgerBarCustomer c5=new BurgerBarCustomer("5",burgerBar,5);

        Thread t1=new Thread(e1,"e1");
        Thread t2=new Thread(e2,"e2");
        Thread t3=new Thread(c1,"c1");
        Thread t4=new Thread(c2,"c2");
        Thread t5=new Thread(c3,"c3");
        Thread t6=new Thread(c4,"c4");
        Thread t7=new Thread(c5,"c5");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
            t7.join();
        }catch (InterruptedException e){

        }
















    }
}
