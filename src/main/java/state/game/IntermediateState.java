package state.game;

public class IntermediateState extends State {
    public IntermediateState(Character character) {
        super(character);
        this.setNextLimit(200);
        character.setMaxHealth(120);
        character.setLevel("Intermediate");
    }

    @Override
    public void action() {
        String[] options = {"Train", "Meditate"};
        switch (this.getCharacter().readOption(options)) {
            case 1:
                this.getCharacter().train();
                if (this.getCharacter().getExperience() >= this.getNextLimit()) {
                    this.getCharacter().setState(new ExpertState(this.getCharacter()));
                }
                break;
            case 2:
                this.getCharacter().meditate();
                break;
        }
    }
}
