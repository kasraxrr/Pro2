public class SoundState implements AlertState{
    @Override
    public void click(Phone phone){
        phone.setStatus(new VibrationState());
    }
    @Override
    public String alert(){
        return "sounddd";
    }
}
