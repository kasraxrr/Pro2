import java.util.ArrayList;
import java.util.Random;

public class King implements Runnable{

    private Door door;
    private Random random=new Random();

    public King(Door door){
        this.door=door;
    }


    @Override
    public void run() {

        while (true)
        {
            int costOfParty = random.nextInt(50);

            Log.getInstance().log(
                    "------------> The king wants to throw a party for " + costOfParty
                            + " in cash money");
            ReadWriteList proxy = door.acquireWrite();

            if (proxy.read() >= costOfParty)
            {
                int collectedMoney = 0;
                ArrayList<Valuables> valuables = new ArrayList<>();

                while (collectedMoney < costOfParty)
                {
                    Valuables valuable = proxy.take();
                    if (valuable != null)
                    {
                        valuables.add(valuable);
                        collectedMoney += valuable.getValue();
                        Log.getInstance().log(
                                "The king added a valuable to the party fund Total Cash: "
                                        + collectedMoney);
                    }
                }
                Log.getInstance().log(
                        "(!!!) The king threw a giant party using " + collectedMoney
                                + " of cash money");
                valuables.clear();
            }
            door.releaseWrite(proxy);

            try
            {
                Thread.sleep(15000);
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}
