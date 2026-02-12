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
    state.volumeUp(this);
    }
    public void volumeDown(){
    state.volumeDown(this);
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
        if (volume<MAX_VOLUME){
            volume++;
        }
    }
    public void decrementVolume(){
        if (volume>MAX_VOLUME){
            volume--;
        }
    }
    public void setMinVolume(){
    volume=MIN_VOLUME;
    }
    public void setMediumVolume(){
    volume=MAX_VOLUME/2;
    }

}
