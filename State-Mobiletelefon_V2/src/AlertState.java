public abstract class AlertState {
    public abstract void click(Phone phone);
    public abstract String alert();

    public void volumeUp(Phone phone){
        phone.incrementVolume();
        System.out.println("volume went up to "+phone.getVolume());
    }
    public void volumeDown(Phone phone){
        phone.decrementVolume();
        System.out.println("volume went down to "+phone.getVolume());
    }
}
