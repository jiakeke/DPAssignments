package state.game;

public class NoviceState extends State {

    public NoviceState(Character character) {
        super(character);
        this.setNextLimit(100);
        character.setLevel("Novice");
    }

    @Override
    public void action() {
        String[] options = {"Train"};
        switch (this.getCharacter().readOption(options)) {
            case 1:
                this.getCharacter().train();
                if (this.getCharacter().getExperience() >= this.getNextLimit()) {
                    this.getCharacter().setState(new IntermediateState(this.getCharacter()));
                }
                break;
        }
    }
}
