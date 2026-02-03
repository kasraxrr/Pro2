public class Mailbox implements Runnable{
    private long maxFrequency;
    private int count;
    private final static long RUNTIME=100000;

    public Mailbox(int count){
        this.count=count;
    }
    private void waitingForMails(){}


    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            count++;
            System.out.println("New mail in your mailbox");
        }
    }
}
