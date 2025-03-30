package state.game;

public class MasterState extends State {
    public MasterState(Character character) {
        super(character);
        this.setNextLimit(300);
        character.setMaxHealth(200);
        character.setLevel("Master");
    }

    @Override
    public void action() {
        System.out.println("Congratulations! You have reached the highest level!");
        System.out.println("You are now a master of the game!");
        System.out.println("Thank you for playing!");
        System.exit(0);
    }
}
