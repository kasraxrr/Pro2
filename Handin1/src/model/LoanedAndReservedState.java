package model;

public class LoanedAndReservedState extends LPState{
    private String loanedTo;
    private String reservedBy;
    private boolean flag;

    public LoanedAndReservedState(LP lp,String loanedTo,String reservedBy,boolean flag){
    this.reservedBy=reservedBy;
    this.loanedTo=loanedTo;
    this.flag=flag;
    }

    @Override
    public String getStatusString() {
        return getClass().getSimpleName();
    }

    @Override
    public boolean getFlag() {
        return flag;
    }

    public void remove(LP lp){
    this.flag=true;
    }

    public void setLoanedTo(String loanedTo) {
        this.loanedTo = loanedTo;
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
       AvailableState a1=new AvailableState(lp,flag);
        lp.setState(a1);
       a1.reserve(lp,reservedBy);

    }
}
