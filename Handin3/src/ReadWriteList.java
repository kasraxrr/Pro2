public interface ReadWriteList extends ReadList{
    void write(Valuables valuables);
    Valuables take();
    @Override
    public int read();
}
