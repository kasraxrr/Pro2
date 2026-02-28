package model;

public class RemovingState extends LPState{
private LPLibrary lpLibrary;

    public RemovingState(LP lp) {
        super(true);
    }

    public String getStatusString(){
    return getClass().getSimpleName();
    }

    @Override
    public void loan(LP lp, String person) {

    }

    @Override
    public void reserve(LP lp, String person) {

    }

    @Override
    public void returnLP(LP lp) {

    }

    @Override
    public void cancelReservation(LP lp) {

    }

    @Override
    public void remove(LP lp) {

    }
}
