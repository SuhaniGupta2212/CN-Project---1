import java.util.*;

class Hub extends Device {
    List<EndDevice> devices = new ArrayList<>();

    Hub(String name, String macAddress) {
        super(name, macAddress);
    }

    void connectDevice(EndDevice d) {
        devices.add(d);
    }

    void broadcast(String data, EndDevice sender) {

        // 🔥 ACCESS CONTROL (CSMA/CD) HERE
        boolean channelBusy = Math.random() > 0.5;

        if (channelBusy) {
            System.out.println("Channel busy... waiting...");
        } else {
            System.out.println("Channel free. Broadcasting...");
        }

        // 🔥 ERROR CONTROL HERE
        boolean ack = Math.random() > 0.3;

        if (!ack) {
            System.out.println("Error occurred! Resending...");
        }

        for (EndDevice d : devices) {
            if (d != sender) {
                d.receiveData(data);
            }
        }

        System.out.println("ACK received!");
    }
}