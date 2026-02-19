public class Driving extends State{
    private boolean lastDirectionForward;
    @Override
    public void click(Car car) {
        car.setState(new Off());
    }
}
