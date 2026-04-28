public class main
{
    public static void main(String[] args)
    {

        Deposit deposit = new RealDeposit();

        Door guardsman = new Guardsman();

        Miner miner1 = new Miner(deposit);
        Miner miner2 = new Miner(deposit);
        Miner miner3 = new Miner(deposit);

        ValuableTransporter transporter = new ValuableTransporter(deposit,
                guardsman);

        Accountant accountant1 = new Accountant(guardsman);
        Accountant accountant2 = new Accountant(guardsman);

        King king = new King(guardsman);

        Thread tMiner1 = new Thread(miner1, "Miner1");
        Thread tMiner2 = new Thread(miner2, "Miner2");
        Thread tMiner3 = new Thread(miner3, "Miner3");
        Thread tTransporter = new Thread(transporter, "Transporter");
        Thread tAccountant1 = new Thread(accountant1, "Accountant1");
        Thread tAccountant2 = new Thread(accountant2, "Accountant2");
        Thread tKing = new Thread(king, "King");

        Log.getInstance().log("--- The Kingdom Simulation is Starting ---");

        tMiner1.start();
        tMiner2.start();
        tMiner3.start();
        tTransporter.start();
        tAccountant1.start();
        tAccountant2.start();
        tKing.start();
    }
}