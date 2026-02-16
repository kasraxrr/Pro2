public class main {
    public static void main(String[] args) {
        Clock clock=new Clock();

        Show show=new Show(clock);
        Update update=new Update(clock);

        Thread t1=new Thread(show,"show");
        Thread t2=new Thread(update,"update");

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }catch (InterruptedException e){
        }




        System.out.println("main ended");

    }
}
