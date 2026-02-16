public class VibrationState implements AlertState{
    @Override
    public void click(Phone phone){
        phone.setStatus(new SilentState());
    }
    @Override
    public String alert(){
        return "Vibration";
    }
}
