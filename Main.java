public class Main {
    public static void main(String[] args) {

        // Create devices
        EndDevice d1 = new EndDevice("A", "MAC1");
        EndDevice d2 = new EndDevice("B", "MAC2");
        EndDevice d3 = new EndDevice("C", "MAC3");

        // Create hub
        Hub hub = new Hub("Hub1", "HUB1");

        hub.connectDevice(d1);
        hub.connectDevice(d2);
        hub.connectDevice(d3);

        // Test Hub communication
        System.out.println("=== HUB TEST ===");
        d1.sendData("Hello from A", hub);

        // Create switch
        Switch sw = new Switch("Switch1", "SW1");

        sw.connectDevice(d1);
        sw.connectDevice(d2);
        sw.connectDevice(d3);

        System.out.println("\n=== SWITCH TEST ===");
        sw.sendData("Message to B", d1, "MAC2");
        sw.sendData("Message to C", d2, "MAC3");
    }
}
