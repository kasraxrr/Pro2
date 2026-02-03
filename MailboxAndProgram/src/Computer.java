public class Computer {
    public static void main(String[] args) throws InterruptedException {
        Mailbox mailbox=new Mailbox(20);
        Program[]programs=new Program[4];
        programs[1]=new Program("Windows","update",30);
        programs[2]=new Program("AVG","update virus database",5);
        programs[3]=new Program("skype","notify : a person is logging in",17);
        System.out.println("Turning on the computer");

        Thread[] threads=new Thread[5];
        for (int i = 0; i < programs.length ; i++) {
            threads[i]=new Thread(programs[i]);
            threads[i].start();
        }
        threads[4]=new Thread(mailbox);
        threads[4].start();

        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        System.out.println("turning off the computer");
    }
}
