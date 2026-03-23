import java.util.*;

class Switch extends Device {
    Map<String, EndDevice> macTable = new HashMap<>();
    List<EndDevice> devices = new ArrayList<>();

    Switch(String name, String macAddress) {
        super(name, macAddress);
    }

    void connectDevice(EndDevice d) {
        devices.add(d);
    }

    void sendData(String data, EndDevice sender, String destMac) {

        // 🔥 MAC LEARNING HERE
        System.out.println("Learning MAC: " + sender.macAddress);
        macTable.put(sender.macAddress, sender);

        // 🔥 FLOW CONTROL HERE
        System.out.println("Sending data...");
        System.out.println("Waiting for ACK...");

        if (macTable.containsKey(destMac)) {
            System.out.println("Sending directly to " + destMac);
            macTable.get(destMac).receiveData(data);
        } else {
            System.out.println("Unknown MAC → Broadcasting...");
            for (EndDevice d : devices) {
                if (d != sender) {
                    d.receiveData(data);
                }
            }
        }

        System.out.println("ACK received!");
    }
}