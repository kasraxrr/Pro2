package main;

public class Sum {

    public int add(int a,int b){
        return a+b;
    }


    public char grade(int num){
        return switch (num) {
            case 100 -> 'A';
            case 90 -> 'B';
            case 80 -> 'C';
            case 70 -> 'D';
            default -> 'F';
        };
    }
    public boolean pass(int n){
        if (n>50)return true;
        else return false;
    }
}
