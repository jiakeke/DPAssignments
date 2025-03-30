package state.game;

import java.util.Scanner;
import java.util.Random;

public class Character {
    private Scanner scanner = new Scanner(System.in);
    private State state;
    private String name;
    private String level;
    private int health;
    private int maxHealth;
    private int experience;
    private Random random = new Random();

    public Character(String name) {
        this.name = name;
        this.state = new NoviceState(this);
        this.health = 100;
        this.maxHealth = 100;
        this.experience = 0;
    }

    public void operate() {
        while (true) {
            if (state == null) {
                // it should not reach here
                System.out.println("Character is confused");
                return;
            }
            System.out.println(
                "\n" + name + " (Level: " + level + ", Health: " + health + "/" + maxHealth +
                ", Experience: " + experience + "/" + state.getNextLimit() + ")");
            state.action();
        }
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setLevel(String level) {
        this.level = level;
        System.out.println("Level up! " + name + " is now a " + level + " player!");
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int readOption(String[] options) {
        System.out.println("\nChoose an option:");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        return scanner.nextInt();
    }

    public void train() {
        System.out.println("Training...");
        int newExperience = random.nextInt((10 - 5) + 1) + 5;
        experience += newExperience;
        System.out.println("Experience increased!");
    }

    public void meditate() {
        System.out.println("Meditating...");
        if (health < maxHealth) {
            int newHealth = random.nextInt((10 - 5) + 1) + 5;
            health += newHealth;
            if (health > maxHealth) {
                health = maxHealth;
                System.out.println("Health increased to maximum!");
            } else {
                System.out.println("Health increased!");
            }
        }
    }

    public void fight() {
        System.out.println("Fighting...");
        String[] frames = {
                "\n" +
                "   O    \n" +
                "  /|\\   \n" +
                "  / \\    \n" +
                "——— Ready ———",

                "\n" +
                "   O/   \n" +
                "  /|    \n" +
                "  / \\    \n" +
                "—— Preparing ——",

                "\n" +
                "  \\O/   \n" +
                "   |    \n" +
                "  / \\    \n" +
                "—— Attacking ——",

                "\n" +
                "   O==> \n" +
                "  /|    \n" +
                "  / \\    \n" +
                "—— Slashing ——",

                "\n" +
                "   O    \n" +
                "  /|\\   \n" +
                "  / \\  X_X \n" +
                "——— Victory ——"
        };
        for (int i = 0; i < 2; i++) {
            for (String frame : frames) {
                System.out.print("\033[H\033[2J"); // clear screen
                System.out.flush();
                System.out.println(frame);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println("Experience increased, Health decreased!");
        int newExperience = random.nextInt((20 - 10) + 1) + 10;
        experience += newExperience;
        int newHealth = random.nextInt((20 - 10) + 1) + 10;
        health -= newHealth;
    }

    public int getExperience() {
        return experience;
    }

    public int getHealth() {
        return health;
    }
}
