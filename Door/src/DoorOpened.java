public class DoorOpened extends DoorState{
    @Override
    public void click(Door door){
        door.setState(new DoorSatyOpen());
    }
    @Override
    public void timeOut(Door door){
        door.setState(new DoorClosing());
    }
}
