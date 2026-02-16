public class SilentState implements AlertState{
    @Override
    public void click(Phone phone){
     phone.setStatus(new SoundState());
    }
    @Override
    public String alert(){
        return "silent";
    }
}
