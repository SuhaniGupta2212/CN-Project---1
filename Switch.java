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
        macTable.put(sender.macAddress, sender);

        if (macTable.containsKey(destMac)) {
            EndDevice receiver = macTable.get(destMac);
            receiver.receiveData(data);
        } else {
            // Broadcast
            for (EndDevice d : devices) {
                if (d != sender) {
                    d.receiveData(data);
                }
            }
        }
    }
}
