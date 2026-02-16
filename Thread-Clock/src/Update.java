import java.util.Scanner;

public class Update implements Runnable{
    private Clock clock;

    public Update(Clock clock){
        this.clock=clock;
    }
    @Override
    public void run(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter the hour");
        int hour=scanner.nextInt();
        System.out.println("enter the minute");
        int minute=scanner.nextInt();
        System.out.println("enter the second");
        int second=scanner.nextInt();
        clock.set(hour,minute,second);
    }


}
