import java.util.ArrayList;

public class LastNameSort implements SortStrategy{

    @Override
    public void sort(ArrayList<Student> students) {

            students.sort((s1, s2) -> s1.getLastName().compareTo(s2.getLastName()));

    }
}
