public class Phone {
    private AlertState state;


    public Phone(){
        this.state=new SilentState();
    }
    public void clickSoundButton(){
        state.click(this);
    }
    public void setStatus(AlertState state){
        this.state=state;
    }
    public void receive(String message){
        System.out.println(message+state.alert());
    }
}
