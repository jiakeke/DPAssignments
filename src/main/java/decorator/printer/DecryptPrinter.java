package decorator.printer;

public class DecryptPrinter extends PrinterDecorator {
    public DecryptPrinter(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String message) {
        super.print(decrypt(message));
    }

    private String decrypt(String message) {
        StringBuilder decrypted = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                decrypted.append(c == 'z' ? 'a' : (char) (c + 1));
            } else if (c >= 'A' && c <= 'Z') {
                decrypted.append(c == 'Z' ? 'Z' : (char) (c + 1));
            } else if (c >= '0' && c <= '9') {
                decrypted.append(c == '9' ? '0' : (char) (c + 1));
            } else {
                decrypted.append(c);
            }
        }
        return decrypted.toString();
    }
}
