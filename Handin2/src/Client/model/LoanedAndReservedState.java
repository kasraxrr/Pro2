package Client.model;

import model.AvailableState;
import model.LP;
import model.LPState;

public class LoanedAndReservedState extends LPState {
    private String loanedTo;
    private String reservedBy;


    public LoanedAndReservedState(LP lp, String loanedTo, String reservedBy, boolean flag){
        super(flag);
    this.reservedBy=reservedBy;
    this.loanedTo=loanedTo;
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

    public void setLoanedTo(String loanedTo) {
        this.loanedTo = loanedTo;
    }

    @Override
    public void loan(LP lp, String person) {

    }

    @Override
    public void reserve(LP lp, String person) {

    }

    public String getLoanedTo() {
        return loanedTo;
    }

    public void setReservedBy(String reservedBy) {
        this.reservedBy = reservedBy;
    }

    public String getReservedBy() {
        return reservedBy;
    }
    public void returnLP(LP lp){
       AvailableState a1=new AvailableState(lp,super.getFlag());
        lp.setState(a1);
       a1.reserve(lp,reservedBy);

    }

    @Override
    public void cancelReservation(LP lp) {

    }
}
