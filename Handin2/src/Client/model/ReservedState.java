package Client.model;

import Client.model.AvailableState;
import Client.model.LP;
import Client.model.LPState;
import Client.model.LoanedState;

public class ReservedState extends LPState {


    public ReservedState(LP lp, String person, boolean flag){
        super(flag);
        super.setReservedBy(person);

    }

    public void cancelReservation(LP lp){
        lp.setState(new AvailableState(lp,super.getFlag()));
    }


    public void remove(LP lp){
        super.setFlag(true);
    }

    public void loan(LP lp,String person){
        if (person.equals(super.getReservedBy())){
            lp.setState(new LoanedState(lp,person,super.getFlag()));
        } else {
            lp.setState(new LoanedAndReservedState(lp,person,super.getReservedBy(),super.getFlag()));
        }
    }

    @Override
    public void reserve(LP lp, String person) {

    }

    @Override
    public void returnLP(LP lp) {

    }
}
