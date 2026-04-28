import java.util.Random;

public class Miner implements Runnable
{
    private String[]types= {"Diamond", "GoldNugget", "Jewel", "Ruby",
            "Ram sticks", "Wooden figurines"};
    private Random random = new Random();
    private Deposit deposit;

    public Miner(Deposit deposit){
    this.deposit=deposit;
    }

    @Override
    public void run() {
        while (true) {
            String type = types[random.nextInt(5)];
            deposit.addValuable(Valuables.getInstance(type));
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
