package abstract_factory.ascii_art;

import abstract_factory.ascii_art.widgets.*;

public class Main {
    public static void main(String[] args) {
        UIFactory factoryA = new AFactory();
        UIFactory factoryB = new BFactory();

        Button buttonA = factoryA.createButton("Submit");
        TextField textFieldA = factoryA.createTextField("Bla Bla Bla");
        Checkbox checkboxA = factoryA.createCheckbox("I Agree.");

        Button buttonB = factoryB.createButton("Login");
        TextField textFieldB = factoryB.createTextField("admin");
        Checkbox checkboxB = factoryB.createCheckbox("Remember Me");

        System.out.println("Style A:");
        textFieldA.display();
        checkboxA.display();
        buttonA.display();

        System.out.println("\nStyle B:");
        textFieldB.display();
        checkboxB.display();
        buttonB.display();

        // Change text dynamically
        buttonA.setText("Save");
        textFieldA.setText("Design Patterns");
        checkboxA.setText("Mark As Read!");

        System.out.println("\nUpdated Style A:");
        textFieldA.display();
        checkboxA.display();
        buttonA.display();
    }
}