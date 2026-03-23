public class Main {
    public static void main(String[] args) {

        // Devices
        EndDevice d1 = new EndDevice("A", "MAC1");
        EndDevice d2 = new EndDevice("B", "MAC2");
        EndDevice d3 = new EndDevice("C", "MAC3");

        // 🔥 HUB TEST
        Hub hub = new Hub("Hub1", "HUB1");
        hub.connectDevice(d1);
        hub.connectDevice(d2);
        hub.connectDevice(d3);

        System.out.println("=== HUB TEST ===");
        d1.sendData("10101", hub);

        // 🔥 SWITCH TEST
        Switch sw = new Switch("Switch1", "SW1");
        sw.connectDevice(d1);
        sw.connectDevice(d2);
        sw.connectDevice(d3);

        System.out.println("\n=== SWITCH TEST ===");
        sw.sendData("Hello B", d1, "MAC2"); // first → broadcast
sw.sendData("Hello C", d2, "MAC3"); // first → broadcast

// 🔥 ADD THIS (IMPORTANT)
sw.sendData("Again Hello B", d1, "MAC2"); // now should be direct
    }
}