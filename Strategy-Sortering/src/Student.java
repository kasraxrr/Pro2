public class Student {
    private String firstName;
    private String lastName;
    private int studyNumber;

    public Student(String firstName,String lastName,int studyNumber){
        this.firstName=firstName;
        this.lastName=lastName;
        this.studyNumber=studyNumber;

    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStudyNumber(int studyNumber) {
        this.studyNumber = studyNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getStudyNumber() {
        return studyNumber;
    }
    public String toString(){
        return firstName+" "+lastName+" "+studyNumber;
    }
}
