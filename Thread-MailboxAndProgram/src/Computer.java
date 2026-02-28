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

        Thread t1=new Thread(mailbox);
        t1.start();
        t1.join();

        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        System.out.println("turning off the computer");
    }
}
