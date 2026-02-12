public class main {
    public static void main(String[] args) {
        Door door=new Door();

        door.click();
        System.out.println(door.status());

        door.complete();
        System.out.println(door.status());

        door.click();
        System.out.println(door.status());

        door.click();
        System.out.println(door.status());

        door.complete();
        System.out.println(door.status());

        door.click();
        System.out.println(door.status());
        door.click();
        System.out.println(door.status());
        door.complete();
        System.out.println(door.status());
    }
}
