package state.game;

public class ExpertState extends State {
    public ExpertState(Character character) {
        super(character);
        this.setNextLimit(300);
        character.setMaxHealth(150);
        character.setLevel("Expert");
    }

    @Override
    public void action() {
        String[] options = {"Train", "Meditate", "Fight"};
        switch (this.getCharacter().readOption(options)) {
            case 1:
                this.getCharacter().train();
                if (this.getCharacter().getExperience() >= this.getNextLimit()) {
                    this.getCharacter().setState(new MasterState(this.getCharacter()));
                }
                break;
            case 2:
                this.getCharacter().meditate();
                break;
            case 3:
                this.getCharacter().fight();
                if (this.getCharacter().getHealth() <= 0) {
                    System.out.println("You have been defeated!");
                    System.out.println("Game over!");
                    System.exit(0);
                }
                if (this.getCharacter().getExperience() >= this.getNextLimit()) {
                    this.getCharacter().setState(new MasterState(this.getCharacter()));
                }
                break;
        }
    }
}
