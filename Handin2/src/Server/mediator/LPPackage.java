package Server.mediator;

import Server.model.LP;

public class LPPackage {
    private String type;
    private String title;
    private String artist;
    private String error;
    private String name;
    private LP lp;


    public LPPackage(String type, LP lp, String title, String artist, String name)
    {
        this.type = type;
        this.lp = lp;
        this.title = title;
        this.artist = artist;
        this.name = name;
        this.error = null;
    }

    public LPPackage(String type, String error)
    {
        this.type = type;
        this.lp = null;
        this.title = null;
        this.artist = null;
        this.name = null;
        this.error = error;
    }

    public String getType()
    {
        return type;
    }

    public String getTitle()
    {
        return title;
    }

    public String getArtist()
    {
        return artist;
    }

    public String getError()
    {
        return error;
    }

    public LP getLP()
    {
        return lp;
    }

    public String getName()
    {
        return name;
    }

    @Override public boolean equals(Object obj)
    {
        if (obj == null || obj.getClass() != getClass())
        {
            return false;
        }
        LPPackage other = (LPPackage) obj;
        return type.equals(other.type) && title.equals(other.title)
                && artist.equals(other.artist) && name.equals(other.name)
                && error.equals(other.error) && lp.equals(other.lp);
    }



}
