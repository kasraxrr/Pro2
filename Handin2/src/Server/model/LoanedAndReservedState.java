package Server.model;

public class LoanedAndReservedState extends LPState{



    public LoanedAndReservedState(LP lp,String loanedTo,String reservedBy,boolean flag){
        super(flag);
        super.setLoanedTo(loanedTo);
        super.setReservedBy(reservedBy);

    }

    @Override
    public boolean getFlag() {
        return super.getFlag();
    }

    @Override
    public void remove(LP lp){
    super.setFlag(true);
    }


    @Override
    public void loan(LP lp, String person) {

    }

    @Override
    public void reserve(LP lp, String person) {

    }

    @Override
    public void returnLP(LP lp){
       ReservedState r1=new ReservedState(lp,super.getReservedBy(),super.getFlag());
        lp.setState(r1);

    }

    @Override
    public void cancelReservation(LP lp) {
    LoanedState l1=new LoanedState(lp,super.getLoanedTo(),super.getFlag());
    lp.setState(l1);
    }
}
