public class ReadProxy implements ReadList{

    private TreasureRoom treasureRoom;

    public ReadProxy(TreasureRoom list){
        treasureRoom=list;
    }

    @Override
    public int read() {
        return treasureRoom.read();
    }

    public void terminate()
    {
        treasureRoom = null;
    }
}
