public class Door {
    private DoorState state;
    public Door(){
        state=new DoorClosed();
    }
    public void complete(){
        state.click(this);
    }
    public void setState(DoorState state){
        this.state=state;
    }
    public String status(){
       return state.status();
    }
    public void timeout(){
        state.timeOut(this);
    }
}
