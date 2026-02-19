public abstract class State {

    public abstract void click(Car car);
    public String status(){
        return getClass().getSimpleName();
    }
}
