package model;

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
    public void loan(LP lp,String person){
        if (getState() instanceof AvailableState || getState() instanceof ReservedState && ){
            this.state=new LoanedState(this,person,flagged);
        }

    }

}
