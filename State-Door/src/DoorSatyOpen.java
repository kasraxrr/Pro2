public class DoorSatyOpen extends DoorState{
    @Override
    public void click(Door door){
        door.setState(new DoorClosing());
    }
}
