import java.util.ArrayList;

public class FirstNameSort implements SortStrategy{

    @Override
    public void sort(ArrayList<Student> students) {

            students.sort((s1, s2) -> s1.getFirstName().compareTo(s2.getFirstName()));

    }
}
