public class Mailbox implements Runnable{
    private long maxFrequency;
    private int count;
    private final static long RUNTIME=100000;

    public Mailbox(int count){
        this.count=count;

        if (this.count > 0) {
            this.maxFrequency = RUNTIME / this.count;
        }
    }
    private void waitingForMails(){
        try {
            Thread.sleep(maxFrequency);
        }catch (InterruptedException e ){

        }

    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("New mail in your mailbox");
            waitingForMails();
        }
    }
}
