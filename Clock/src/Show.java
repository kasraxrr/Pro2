public class Show implements Runnable{

    private Clock clock;

    public Show(Clock clock){
        this.clock=clock;
    }

    @Override
    public void run(){
        for (int i = 0; i < 5*60; i++) {
            System.out.println(clock.toString());
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){

            }
        }
    }

}
