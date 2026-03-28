package Client.viewmodel;

import Client.model.LP;

public class ViewState {
    private LP selectedLP;
    private String title;
    private String artist;
    public ViewState(){
    this.title=null;
    this.artist=null;
    }

    public void setSelectedLP(LP selectedLP) {
        this.selectedLP = selectedLP;
    }

    public LP getSelectedLP() {
        return selectedLP;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }
}
