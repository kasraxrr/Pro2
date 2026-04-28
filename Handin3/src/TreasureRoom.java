import java.util.ArrayList;

public class TreasureRoom implements ReadWriteList{

    private ArrayList<Valuables> valuables;

    public TreasureRoom(){
        this.valuables=new ArrayList<>();
    }

    @Override
    public void write(Valuables valuable) {
    valuables.add(valuable);
    }

    @Override
    public Valuables take() {
        return valuables.removeFirst();
    }

    @Override
    public int read() {
        int total = 0;
        for (int i = 0; i < valuables.size(); i++)
        {
            total += valuables.get(i).getValue();
        }
        return total;
    }
}
