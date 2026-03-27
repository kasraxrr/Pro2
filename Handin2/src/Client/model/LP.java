package Client.model;

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

            this.state.loan(this,person);

    }

    public void reserve(String person){
            this.state.reserve(this,person);
    }

    public void cancelReservation(){
            this.state.cancelReservation(this);

    }
    public void returnLP(){

            this.state.returnLP(this);

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
