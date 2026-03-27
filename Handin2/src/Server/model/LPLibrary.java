package Server.model;

import model.LP;

import java.util.ArrayList;

public class LPLibrary {
    private ArrayList<LP> list;

    public LPLibrary(){
    this.list=new ArrayList<>();
    }
    public int size(){
        return list.size();
    }
    public void add(LP lp){
        list.add(lp);
    }
    public void remove(LP lp){

            list.remove(lp);

    }
    public void remove(int index){
        list.remove(index);
    }
    public LP getLP(int index){
       return list.get(index);
    }
    public LP getLP(String title,String artist){
        for (LP lp : list) {
            if (lp.getTitle().equals(title) && lp.getArtist().equals(artist)) {
                return lp;
            }
        }
        return null;
    }
    public void loan(LP lp,String loanerName){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(lp)){
                list.get(i).loan(loanerName);
            }
        }
    }

    public void reserve(LP lp,String name){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(lp)){
                list.get(i).reserve(name);
            }
        }
    }

    public void cancel(LP lp){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(lp)){
                list.get(i).cancelReservation();
            }
        }
    }

    public void returnLP(LP lp){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(lp)){
                list.get(i).returnLP();
            }
        }
    }
    public void flagRemoveLP(LP lp){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(lp)){
                list.get(i).setFlagged(true);
            }
        }
    }

    public void unflag(LP lp){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(lp)){
                list.get(i).setFlagged(false);
            }
        }
    }

    public void flagRemoveLP(int index){
        list.get(index).setFlagged(true);
    }
    public ArrayList<LP>getAllLPs(){
        return list;
    }

}
