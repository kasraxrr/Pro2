import java.util.ArrayList;

public class StudyNumberSort implements SortStrategy{
    @Override
    public void sort(ArrayList<Student> students) {
        students.sort((s1, s2) -> Integer.compare(s1.getStudyNumber(), s2.getStudyNumber()));
    }
}
