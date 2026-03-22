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
        for (EndDevice d : devices) {
            if (d != sender) {
                d.receiveData(data);
            }
        }
    }
}
