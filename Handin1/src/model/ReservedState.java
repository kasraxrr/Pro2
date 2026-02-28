package model;

public class ReservedState extends LPState{
    private String reservedBy;
    private boolean flag;

    public ReservedState(LP lp, String person, boolean flag){
        this.reservedBy=person;
        this.flag=flag;
    }

    public void cancelReservation(LP lp){
    lp.setState(new AvailableState(lp,flag));
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

    public void setReservedBy(String reservedBy) {
        this.reservedBy = reservedBy;
    }

    public String getReservedBy() {
        return reservedBy;
    }
    public void loan(LP lp,String person){
        if (person.equals(reservedBy)){
            lp.setState(new LoanedState(lp,person,flag));
        }
    }
}
