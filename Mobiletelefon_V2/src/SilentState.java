public class SilentState extends AlertState{
    public SilentState(Phone phone){
    phone.setMinVolume();
    }

    @Override
    public void click(Phone phone) {
        phone.setState(new SoundState());
        phone.setMediumVolume();
    }
    @Override
    public String alert(){
        return "phone is silenced";
    }
    @Override
    public void volumeUp(Phone phone){
        phone.volumeUp();
    }
}
