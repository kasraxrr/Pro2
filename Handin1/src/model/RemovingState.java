package model;

public class RemovingState extends LPState{
    public RemovingState(LP lp){
        LPLibrary.remove(lp);
    }

    public String getStatusString(){
    return getClass().getSimpleName();
    }
}
