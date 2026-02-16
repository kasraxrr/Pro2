public class Clock {
    private int hour;
    private int minute;
    private int second;

    public Clock(){
        this.hour=0;
        this.minute=0;
        this.second=0;
    }
    public void set(int hour,int minute,int second){
        this.hour=hour;
        this.minute=minute;
        this.second=second;
    }
    public String toString(){
      return hour+":"+minute+":"+second;
    }
}
