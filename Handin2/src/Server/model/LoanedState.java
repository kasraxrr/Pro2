package Server.model;

public class LoanedState extends LPState{


    public LoanedState(LP lp,String person,boolean flag){
        super(flag);
        super.setLoanedTo(person);

    }
    public void returnLP(LP lp){
        if (super.getFlag()) {
            lp.setState(new RemovingState(lp));
        } else {
            lp.setState(new AvailableState(lp, super.getFlag()));
        }
    }

    @Override
    public void cancelReservation(LP lp) {

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
            lp.setState(new LoanedAndReservedState(lp, super.getLoanedTo(), person, super.getFlag()));
        } else {
            throw new IllegalStateException("Cannot reserve this LP");
        }
    }



    @Override
    public void loan(LP lp, String person) {

    }



}
