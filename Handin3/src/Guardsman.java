public class Guardsman implements Door{

    private TreasureRoom treasureRoom;
    private int readers;
    private int writers;
    private int waitingWriters;


    public Guardsman()
    {
        treasureRoom = new TreasureRoom();
        readers = 0;
        writers = 0;
        waitingWriters = 0;
    }

    @Override
    public synchronized ReadList acquireRead() {
        while (waitingWriters > 0 || writers > 0)
        {
            try
            {
                Log.getInstance().log(
                        Thread.currentThread().getName() + " is waiting to acquire read");
                wait();
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
        readers++;
        return new ReadProxy(treasureRoom);
    }

    @Override
    public synchronized void releaseRead(ReadList list) {
        Log.getInstance()
                .log(Thread.currentThread().getName() + " is releasing read");
        ReadProxy readProxy = (ReadProxy) list;
        readProxy.terminate();
        readers--;
        if (readers == 0)
        {
            notifyAll();
        }
    }

    @Override
    public synchronized ReadWriteList acquireWrite() {
        waitingWriters++;
        while (readers > 0 || writers > 0)
        {
            try
            {
                Log.getInstance().log(
                        Thread.currentThread().getName() + " is waiting to acquire write");
                wait();
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
        waitingWriters--;
        writers++;
        return new WriteProxy(treasureRoom);
    }

    @Override
    public synchronized void releaseWrite(ReadWriteList list) {
        Log.getInstance()
                .log(Thread.currentThread().getName() + " is releasing write");
        WriteProxy writeProxy = (WriteProxy) list;
        writeProxy.terminate();
        writers--;
        notifyAll();
    }
}
