public class Phone {
    private final static int MIN_VOLUME=0;
    private final static int MAX_VOLUME=10;
    private int volume;
    private AlertState state;

    public Phone(){
        this.state=new SilentState(this);
        this.volume=0;
    }
    public void clickSoundButton(){
        state.click(this);
    }
    public void volumeUp(){
        if (volume<MAX_VOLUME){
            volume++;
        }
    }
    public void volumeDown(){
        if (volume>MAX_VOLUME){
            volume--;
        }
    }
    public int getVolume(){
        return volume;
    }
    public void receive(String message){
        System.out.println(message+state.alert());
    }
    public void setState(AlertState state){
        this.state=state;
    }
    public void incrementVolume(){

    }
    public void decrementVolume(){

    }
    public void setMinVolume(){

    }
    public void setMaxVolume(){

    }
}
