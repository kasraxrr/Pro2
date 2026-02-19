public class Car {
    private State state;

    public void click(){
        state.click(this);
    }
    public void setState(State state){
        this.state=state;
    }
    public String status(){
        return state.status();
    }
}
