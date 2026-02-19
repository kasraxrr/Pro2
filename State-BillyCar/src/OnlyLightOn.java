public class OnlyLightOn extends State{
    @Override
    public void click(Car car) {
        car.setState(new Off());
    }
}
