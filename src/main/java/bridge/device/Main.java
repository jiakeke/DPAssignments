package bridge.device;

public class Main {
    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());

        System.out.println("Testing Smart Device with Smart Remote:");
        testSmartDevice();
    }
    public static void testSmartDevice() {
        Device smartTV = new SmartTV();
        SmartRemote smartRemote = new SmartRemote(smartTV);

        smartRemote.power();
        smartRemote.volumeUp();
        smartRemote.voiceControl("Open YouTube");
        ((SmartTV) smartTV).browseInternet();
        smartTV.printStatus();
    }

    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }
}



