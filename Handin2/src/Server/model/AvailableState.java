package Server.model;

import Server.model.LP;
import Server.model.LPState;
import Server.model.LoanedState;
import Server.model.RemovingState;

public class AvailableState extends LPState {

    public AvailableState(LP lp , boolean flag){
        super(flag);


    }
    public void loan(LP lp,String person){
        lp.setState(new LoanedState(lp,person,super.getFlag()));
    }
    public void remove(LP lp) {

         lp.setState(new RemovingState(lp));

    }

    public void reserve(LP lp,String person){
        lp.setState(new ReservedState(lp,person,super.getFlag()));
    }

    @Override
    public void returnLP(LP lp) {

    }

    @Override
    public void cancelReservation(LP lp) {

    }

    @Override
    public String getStatusString(){
        return getClass().getSimpleName();
    }
    public boolean getFlag(){
        return super.getFlag();
    }
}
