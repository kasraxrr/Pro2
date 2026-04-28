import java.util.Random;

public class Accountant implements Runnable{
    private Door door;
    private Random random = new Random();

    public Accountant(Door door){
        this.door=door;
    }

    @Override
    public void run() {
        while (true)
        {
            ReadList proxy = door.acquireRead();
            int totalMoney = proxy.read();

            try
            {
                Thread.sleep(random.nextInt(1000));
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }

            Log.getInstance().log(
                    "Accountant has counted the treasure room: " + totalMoney
                            + " in cash money");
            door.releaseRead(proxy);
            try
            {
                Thread.sleep(random.nextInt(3000));
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}
