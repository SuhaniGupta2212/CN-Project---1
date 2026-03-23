class LineEncoding {

    static String NRZ(String data) {
        String result = "";
        for (char c : data.toCharArray()) {
            result += (c == '1') ? "HIGH " : "LOW ";
        }
        return result;
    }

    static String Manchester(String data) {
        String result = "";
        for (char c : data.toCharArray()) {
            result += (c == '1') ? "LOW-HIGH " : "HIGH-LOW ";
        }
        return result;
    }
}