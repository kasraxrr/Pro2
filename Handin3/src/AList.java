import utility.collection.ListADT;
import utility.collection.ArrayList;

public class AList<T> implements ListADT<T> {

    private static final int DEFAULT=16;
    private int size;
    private ArrayList<T>elements;

    public AList() {
        this.elements = new ArrayList<>();
        this.size = 0;
    }


    @Override
    public void add(int index, T element) {
    elements.add(index,element);
    }

    @Override
    public void add(T element) {
    elements.add(element);
    }

    @Override
    public void set(int index, T element) {
    elements.set(index,element);
    }

    @Override
    public T get(int index) {
        return elements.get(index);
    }

    @Override
    public T remove(int index) {
       return elements.remove(index);
    }

    @Override
    public T remove(T element) {
        T ele = null;

        for (int i = 0; i < elements.size(); i++)
        {
            if (elements.get(i).equals(element))
            {
                ele = elements.get(i);
            }
        }
        elements.remove(element);
        return ele;
    }

    @Override
    public int indexOf(T element) {
        return elements.indexOf(element);
    }

    @Override
    public boolean contains(T element) {
        return elements.contains(element);
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public boolean isFull() {
        return elements.isFull();
    }

    @Override
    public int size() {
        return elements.size();
    }
}
