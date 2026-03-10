import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        StudentSorter studentSorter=new StudentSorter();
        Student s1=new Student("a","b",3);
        Student s2=new Student("b","c",1);
        Student s3=new Student("c","a",2);
        ArrayList<Student>students=new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        System.out.println(students);
        studentSorter.sort(students);
        System.out.println(students);

    }
}
