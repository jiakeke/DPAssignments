package decorator.printer;

public class EncryptPrinter extends PrinterDecorator {
    public EncryptPrinter(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String message) {
        super.print(encrypt(message));
    }

    private String encrypt(String message) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                encrypted.append(c == 'a' ? 'z' : (char) (c - 1));
            } else if (c >= 'A' && c <= 'Z') {
                encrypted.append(c == 'A' ? 'Z' : (char) (c - 1));
            } else if (c >= '0' && c <= '9') {
                encrypted.append(c == '0' ? '9' : (char) (c - 1));
            } else {
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }
}
