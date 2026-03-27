package Client.model;

import model.LP;

public class LoanedState extends LPState{
    private String loanedTo;


    public LoanedState(LP lp, String person, boolean flag){
        super(flag);
        this.loanedTo=person;

    }
    public void returnLP(LP lp){
        if (this.getFlag()) {
            lp.setState(new RemovingState(lp));
        } else {
            lp.setState(new AvailableState(lp, false));
        }
    }

    @Override
    public void cancelReservation(LP lp) {

    }

    @Override
    public String getStatusString() {
        return getClass().getSimpleName();
    }


    public boolean getFlag() {
        return super.getFlag();
    }
    public void remove(LP lp){
        super.setFlag(true);
    }
    @Override
    public void reserve(LP lp, String person) {
        if (!super.getFlag() && super.getReservedBy() == null) {
            lp.setState(new LoanedAndReservedState(lp, this.getLoanedTo(), person, false));
        } else {
            throw new IllegalStateException("Cannot reserve this LP");
        }
    }

    public void setLoanedTo(String person ){
        this.loanedTo=person;
    }

    @Override
    public void loan(LP lp, String person) {

    }

    public String getLoanedTo(){
        return loanedTo;
    }

}
