package model;

public class RemovingState extends LPState{
private LPLibrary lpLibrary;

    public RemovingState(LP lp) {
        super(true);
    }

    public String getStatusString(){
    return getClass().getSimpleName();
    }
}
