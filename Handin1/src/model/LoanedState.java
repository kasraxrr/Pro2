package model;

public class LoanedState extends LPState{
    private String loanedTo;
    private boolean flag;

    public LoanedState(LP lp,String person,boolean flag){
        this.loanedTo=person;
        this.flag=flag;
    }
    public void returnLP(LP lp){
        lp.setState(new AvailableState(lp,flag));
    }

    @Override
    public String getStatusString() {
        return getClass().getSimpleName();
    }


    public boolean getFlag() {
        return flag;
    }
    public void remove(LP lp){
        this.flag=true;
    }
    public void reserve(LP lp,String person){
        if (!flag){
            lp.setState(new LoanedAndReservedState(lp,loanedTo,person,false));
        }
        else {
            throw new IllegalStateException();
        }

    }
    public void setLoanedTo(String person ){
        this.loanedTo=person;
    }
    public String getLoanedTo(){
        return loanedTo;
    }

}
