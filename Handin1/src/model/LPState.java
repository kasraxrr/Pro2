package model;

public abstract class LPState {
    private boolean flag;
    private String reservedBy;
    private String loanedTo;
    public LPState(boolean flag){
        this.flag=flag;
    }

public String getStatusString(){
        return getClass().getSimpleName();
}
public boolean getFlag(){
        return flag;
}
public void setFlag(Boolean flag){
        this.flag=flag;
}

    public String getReservedBy() {
        return reservedBy;
    }

    public void setReservedBy(String reservedBy) {
        this.reservedBy = reservedBy;
    }

    public String getLoanedTo() {
        return loanedTo;
    }

    public void setLoanedTo(String loanedTo) {
        this.loanedTo = loanedTo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)return true;
        if ( obj==null||this.getClass()!=obj.getClass())return false;
        LPState other=(LPState) obj;
        return this.getFlag()== other.getFlag() && this.getReservedBy().equals(other.getReservedBy()) && this.getLoanedTo().equals(other.getLoanedTo());
    }
    public void loan(LP lp, String person) {
    }

    public void reserve(LP lp, String person) {
    }

    public void returnLP(LP lp) {
    }

    public void cancelReservation(LP lp) {
    }

    public void remove(LP lp) {
    }
}
