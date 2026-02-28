package model;

import java.util.Objects;

public class LP {
    private String title;
    private String artist;
    private int year;
    private LPState state;
    private boolean flagged;

    public LP(String title,String artist,int year){
        this.title=title;
        this.artist=artist;
        this.year=year;
        this.flagged=false;
        this.state=new AvailableState(this,flagged);
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
        this.flagged=flagged;
    }
    public boolean isFlagged(){
        return flagged;
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
            this.state=new LoanedState(this,person,flagged);
        }
    }

    public void reserve(String person){
        if (getState() instanceof AvailableState && !flagged){
            this.state=new ReservedState(this,person,flagged);
        } else if (getState() instanceof LoanedState && !(getState() instanceof LoanedAndReservedState) && !flagged) {
            this.state=new LoanedAndReservedState(this,state.getLoanedTo(),person,flagged);
        }
    }

    public void cancelReservation(){
        if (getState() instanceof ReservedState){
            this.state=new AvailableState(this,flagged);
        }
        else if (getState() instanceof  LoanedAndReservedState) {
            this.state=new LoanedState(this,state.getLoanedTo(),flagged);
        }
    }
    public void returnLP(){
        if (getState() instanceof LoanedState){
            this.state=new AvailableState(this,flagged);
        }
        if (getState() instanceof LoanedAndReservedState && !flagged){
            this.state=new AvailableState(this,flagged);
            reserve(state.getReservedBy());
        }
        if (getState() instanceof LoanedAndReservedState && flagged){
            this.state=new AvailableState(this,flagged);
        }
    }
    public String toString(){
      return   title+artist+year+state+flagged;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        LP lp = (LP) object;
        return year == lp.year && flagged == lp.flagged && Objects.equals(title, lp.title) && Objects.equals(artist, lp.artist) && Objects.equals(state, lp.state);
    }

}
