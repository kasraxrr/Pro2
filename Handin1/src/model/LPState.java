package model;

public abstract class LPState {
    public void loan(LP lp,String person){}
    public void reserve(LP lp,String  person){}
    public void returnLP(LP lp){}
    public void cancelReservation(LP lp){}
    public void remove(LP lp){}
    public abstract String getstatusString();
    public boolean canBeRemoved(){
        return (getClass().getSimpleName().equals("AvailableState"));
    }
}
