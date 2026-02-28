package model;

public abstract class LPState {
    public void loan(LP lp,String person){}
    public void reserve(LP lp,String  person){}
    public void returnLP(LP lp){}
    public void setFlag(LP lp){}
    public void remove(LP lp){}
    public abstract String getStatusString();
    public boolean getFlag(){
        return (getClass().getSimpleName().equals("AvailableState"));
    }
}
