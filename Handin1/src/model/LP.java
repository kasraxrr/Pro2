package model;

import java.util.Objects;

public class LP {
    private String title;
    private String artist;
    private int year;
    private LPState state;


    public LP(String title,String artist,int year){
        this.title=title;
        this.artist=artist;
        this.year=year;
        this.state=new AvailableState(this,false);
    }
    public void setTitle(String title){
        this.title=title;
    }
    public String getTitle(){
        return title;
    }
    public void setArtist(String artist){
        this.artist=artist;
    }
    public String getArtist(){
        return artist;
    }
    public void setYear(int year){
        this.year=year;
    }
    public int getYear(){
        return year;
    }
    public void setFlagged(boolean flagged){
        this.state.setFlag(flagged);
    }
    public boolean isFlagged(){
        return state.getFlag();
    }
    public void setState(LPState state){
        this.state=state;
    }
    public LPState getState(){
        return state;
    }
    public String getStateString(){
        return state.getStatusString();
    }
    public void loan(String person){
        if (getState() instanceof AvailableState || getState() instanceof ReservedState && state.getReservedBy().equals(person)){
            this.state=new LoanedState(this,person,state.getFlag());
        }
    }

    public void reserve(String person){
        if (getState() instanceof AvailableState && !state.getFlag()){
            this.state=new ReservedState(this,person,state.getFlag());
        } else if (getState() instanceof LoanedState && !(getState() instanceof LoanedAndReservedState) && !state.getFlag()) {
            this.state=new LoanedAndReservedState(this,state.getLoanedTo(),person,state.getFlag());
        }
    }

    public void cancelReservation(){
        if (getState() instanceof ReservedState){
            this.state=new AvailableState(this,state.getFlag());
        }
        else if (getState() instanceof  LoanedAndReservedState) {
            this.state=new LoanedState(this,state.getLoanedTo(),state.getFlag());
        }
    }
    public void returnLP(){
        if (getState() instanceof LoanedState){
            this.state=new AvailableState(this,state.getFlag());
        }
        if (getState() instanceof LoanedAndReservedState && !state.getFlag()){
            this.state=new AvailableState(this,state.getFlag());
            reserve(state.getReservedBy());
        }
        if (getState() instanceof LoanedAndReservedState && state.getFlag()){
            this.state=new AvailableState(this,state.getFlag());
        }
    }
    public String toString(){
      return   title+artist+year+state+state.getFlag();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        LP lp = (LP) object;
        return year == lp.year && Objects.equals(title, lp.title) && Objects.equals(artist, lp.artist) && Objects.equals(state, lp.state);
    }

}
