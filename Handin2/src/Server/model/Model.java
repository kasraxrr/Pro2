package Server.model;

import model.LP;
import model.UnnamedPropertyChangeSubject;

import java.util.ArrayList;

public interface Model extends UnnamedPropertyChangeSubject {
public ArrayList<LP> getAllLPs();
public LP getLP(String title,String artist);
public void addLP(LP lp);
public void removeLP(LP lp);
public void remove(int index);
public void reserve(LP lp,String person);
public void cancel(LP lp);
public void loan(LP lp,String person);
public void returnLP(LP lp);
public void flagForRemove(LP lp);
public void unflag(LP lp);
public void flagFoeRemove(int index);

}
