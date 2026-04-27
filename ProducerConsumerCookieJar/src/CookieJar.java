import java.util.ArrayList;

public class CookieJar {
    private ArrayList<Cookie>cookies;
    private int cookieCountWhenToBake;
    private int numberOfCookiesInTheOven;
    private int plateSize;
    private int numberOfCookies;

    public CookieJar(int jarSize,int cookieCountWhenToBake,int cookiePlateSize){
    this.cookieCountWhenToBake=cookieCountWhenToBake;
    this.plateSize=cookiePlateSize;
    cookies=new ArrayList<>();
    numberOfCookies=0;

    }
    public synchronized void startBaking(){
        for (int i = 0; i < 16; i++) {
            cookies.add(new Cookie("choco"));
        }
    }
    public synchronized int finishedBaking(){

        return 0;
    }
    public synchronized void eat(){
            cookies.remove(0);
    }

}
