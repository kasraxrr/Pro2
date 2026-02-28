package model;

public class AvailableState extends LPState{

    public AvailableState(LP lp , boolean flag){
        super(flag);

    if (flag){
        remove(lp);
    }
    }
    public void loan(LP lp,String person){
        lp.setState(new LoanedState(lp,person,false));
    }
    public void remove(LP lp) {

         lp.setState(new RemovingState(lp));

    }

    public void reserve(LP lp,String person){
        lp.setState(new ReservedState(lp,person,false));
    }
    @Override
    public String getStatusString(){
        return getClass().getSimpleName();
    }
    public boolean getFlag(){
        return super.getFlag();
    }
}
