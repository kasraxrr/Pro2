public class main {
    public static void main(String[] args) {

        ThreadSafeLinkedList<Object> t=new ThreadSafeLinkedList<>(1);

        t.add("Hello");
        t.add("Hi");
        t.add("How are you");
        t.add("Bye");
        t.add("fuck");
        t.remove("fuck");
        System.out.println(t.toString());


















    }
}
