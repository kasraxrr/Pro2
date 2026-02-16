public class VibrationState extends AlertState{
    @Override
    public void click(Phone phone) {
        phone.setState(new SilentState(phone));
    }
    @Override
    public String alert(){
        return "phone is on Vibrate";
    }
}
