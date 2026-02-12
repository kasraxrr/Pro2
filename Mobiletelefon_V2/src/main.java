public class main {
    public static void main(String[] args) {
        Phone phone=new Phone();

        System.out.println("=== START ===");
        System.out.println("Initial volume: " + phone.getVolume());
        System.out.println();

        // Test 1: Klik fra Silent -> Sound
        System.out.println("Klik (Silent -> Sound)");
        phone.clickSoundButton();
        System.out.println("Volume: " + phone.getVolume());
        System.out.println();

        // Test 2: Skru op flere gange
        System.out.println("Volume Up x3");
        phone.volumeUp();
        phone.volumeUp();
        phone.volumeUp();
        System.out.println("Volume: " + phone.getVolume());
        System.out.println();

        // Test 3: Alert i SoundState
        System.out.println("Alert:");
        phone.receive("Devin har brug for hjælp");
        System.out.println();

        // Test 4: Klik fra Sound -> Vibration
        System.out.println("Klik (Sound -> Vibration)");
        phone.clickSoundButton();
        System.out.println("Alert:");
        phone.receive("Victor har brug for hjælp");
        System.out.println();

        // Test 5: Klik fra Vibration -> Silent
        System.out.println("Klik (Vibration -> Silent)");
        phone.clickSoundButton();
        System.out.println("Alert:");
        phone.receive("Victor og Devin har brug for hjælp");
        System.out.println();

        // Test 6: VolumeDown ved minimum
        System.out.println("Volume Down ved minimum");
        phone.volumeDown();
        System.out.println("Volume: " + phone.getVolume());
        System.out.println();

        System.out.println("=== SLUT ===");















    }
}
