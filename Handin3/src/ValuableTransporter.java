import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ValuableTransporter implements Runnable{

    private Deposit deposit;
    private Door door;
    private Random random = new Random();

    public ValuableTransporter(Deposit deposit,Door door){
        this.door=door;
        this.deposit=deposit;
    }

    @Override
    public void run() {
        while (true)
        {
            int target = random.nextInt(30);
            List<Valuables> pocket = new ArrayList<>();

            Log.getInstance().log(
                    "------------> " + Thread.currentThread().getName() + " needs "
                            + target + " treasures to transport");

            while (pocket.size() < target)
            {
                Valuables valuables = deposit.takeValuable();
                pocket.add(valuables);
            }

            Log.getInstance().log(
                    Thread.currentThread().getName() + " collected: " + pocket.size()
                            + " items");


            ReadWriteList proxy = door.acquireWrite();

            for (int i = 0; i < pocket.size(); i++)
            {
                proxy.write(pocket.get(i));
            }
            Log.getInstance().log(
                    Thread.currentThread().getName() + " dropped of " + pocket.size()
                            + " items into the treasure room");
            door.releaseWrite(proxy);
            pocket.clear();

            try
            {
                Thread.sleep(random.nextInt(5000) + 5000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
