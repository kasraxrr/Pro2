package Client.model;

import model.AvailableState;
import model.LP;
import model.LPState;
import model.LoanedState;

public class ReservedState extends LPState {
    private String reservedBy;

    public ReservedState(LP lp, String person, boolean flag){
        super(flag);
        this.reservedBy=person;

    }

    public void cancelReservation(LP lp){
    lp.setState(new AvailableState(lp,super.getFlag()));
    }

    @Override
    public String getStatusString() {
        return getClass().getSimpleName();
    }

    @Override
    public boolean getFlag() {
        return super.getFlag();
    }

    public void remove(LP lp){
    super.setFlag(true);
    }

    public void setReservedBy(String reservedBy) {
        this.reservedBy = reservedBy;
    }

    public String getReservedBy() {
        return reservedBy;
    }
    public void loan(LP lp,String person){
        if (person.equals(reservedBy)){
            lp.setState(new LoanedState(lp,person,super.getFlag()));
        }
    }

    @Override
    public void reserve(LP lp, String person) {

    }

    @Override
    public void returnLP(LP lp) {

    }
}
