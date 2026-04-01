package Server.mediator;

import Server.model.LP;

import java.util.ArrayList;

public class LPListPackage {
    private String type;
    private ArrayList<LP> lps;

    public LPListPackage(String type)
    {
        this.type = type;
        lps = new ArrayList<>();
    }

    public LPListPackage(String type, ArrayList<LP> lps)
    {
        this.type = type;
        this.lps = lps;
    }


    public String getType()
    {
        return type;
    }

    public ArrayList<LP> getLps()
    {
        return lps;
    }

    @Override
    public String toString()
    {
        return "type="+type+" lps="+lps;
    }


















}
