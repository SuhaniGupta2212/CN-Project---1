class EndDevice extends Device {

    EndDevice(String name, String macAddress) {
        super(name, macAddress);
    }

    void sendData(String data, Hub hub) {
        System.out.println(name + " sending: " + data);

        // LINE ENCODING HERE
        String encoded = LineEncoding.Manchester(data);
        System.out.println("Encoded Data: " + encoded);

        hub.broadcast(data, this);
    }

    void receiveData(String data) {
        System.out.println(name + " received: " + data);
    }
}