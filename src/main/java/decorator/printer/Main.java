package decorator.printer;

public class Main {

    public static void main(String[] args) {
        Printer printer;

        printer = new BasicPrinter();
        printer.print("Hello, World 2025!");

        printer = new XMLPrinter(new BasicPrinter());
        printer.print("Hello, World 2025!");

        printer = new EncryptPrinter(new XMLPrinter(new BasicPrinter()));
        printer.print("Hello, World 2025!");

        printer = new EncryptPrinter(new DecryptPrinter(new XMLPrinter(new BasicPrinter())));
        printer.print("Hello, World 2025!");

    }
}
