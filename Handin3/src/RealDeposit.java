import utility.collection.ListADT;

public class RealDeposit implements Deposit{
    private ListADT<Valuables>list;

    public RealDeposit(){
        this.list=new AList<>();
    }
    @Override
    public synchronized void addValuable(Valuables valuables) {

        while (list.size() >= 16)
        {
            try
            {
                Log.getInstance().log("Miner is waiting (the deposit is already full)");
                wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        list.add(valuables);
        Log.getInstance().log(
                "Miner added a " + valuables.getType() + "\nTotal deposited treasures "
                        + list.size());
        notifyAll();
    }

    @Override
    public synchronized Valuables takeValuable() {
        while (list.isEmpty())
        {
            try
            {
                Log.getInstance()
                        .log("Valuable Transporter is waiting (the deposit is empty)");
                wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        Valuables valuables = list.remove(0);
        Log.getInstance().log(
                "Valuable Transporter is transporting a " + valuables.getType()
                        + "\nTotal deposited treasures " + list.size());
        notifyAll();
        return valuables;
    }
}
