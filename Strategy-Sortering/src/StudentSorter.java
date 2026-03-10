import java.util.ArrayList;

public class StudentSorter {
    private SortStrategy sortStrategy;

    public StudentSorter(SortStrategy strategy){
        this.sortStrategy=strategy;
    }
    public StudentSorter(){
        SortStrategy sortStrategy1=new FirstNameSort();
    }
    public void set(SortStrategy strategy){
        this.sortStrategy=strategy;
    }
    public void sort(ArrayList<Student>students){
        sortStrategy.sort(students);
    }

}
