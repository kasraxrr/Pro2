public class Off extends State{
    private boolean droveLast;

    @Override public void click(Car car){
        if (droveLast){
            car.setState(new OnlyLightOn());
        }else {
            car.setState(new Driving());
        }
    }
}
