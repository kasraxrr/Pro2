public class Program implements Runnable{

    private String program;
    private long maxFrequency;
    private String action;
    private int count;
    private static final long RUNTIME=100000;

    public Program(String program,String action,int count){
    this.program=program;
    this.action=action;
    this.count=count;
    if (this.count > 0) {
        this.maxFrequency = RUNTIME / this.count;
      }
    }
    public void normalOperation(){
        try {
            Thread.sleep(maxFrequency);
        }
        catch (InterruptedException e){

        }
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println(program+" Wants to "+action);
            normalOperation();
        }
    }
}
