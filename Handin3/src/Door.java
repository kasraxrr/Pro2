public interface Door {
    ReadList acquireRead();
    void releaseRead(ReadList list);
    ReadWriteList acquireWrite();
    void releaseWrite(ReadWriteList list);

}
