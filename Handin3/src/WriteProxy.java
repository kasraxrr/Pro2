public class WriteProxy implements ReadWriteList
{
    private TreasureRoom treasureRoom;

    public WriteProxy(TreasureRoom treasureRoom)
    {
        this.treasureRoom = treasureRoom;
    }

    @Override public void write(Valuables value)
    {
        treasureRoom.write(value);
    }

    @Override public Valuables take()
    {
        return treasureRoom.take();
    }

    @Override public int read()
    {
        return treasureRoom.read();
    }

    public void terminate()
    {
        treasureRoom = null;
    }
}