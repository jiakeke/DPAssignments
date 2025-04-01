package template_method.game;

import java.util.ArrayList;
import java.util.List;

public class DiceGame extends Game{
    List<Integer> players = new ArrayList<>();
    int numberOfPlayers = 0;
    int turns = 0;
    @Override
    public void initializeGame(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(0);
        }
    }

    @Override
    public boolean endOfGame() {
        return turns >= numberOfPlayers * 3;
    }

    @Override
    public void playSingleTurn(int player) {
        int total = 0;
        for (int i = 0; i < 4; i++) {
            total += (int) (Math.random() * 6) + 1;
        }
        turns++;
        players.set(player, players.get(player) + total);
    }

    @Override
    public void displayWinner() {
        int max = 0;
        List<String> winners = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            int player = i + 1;
            System.out.println("Player " + player + " scored " + players.get(i));
            if (players.get(i) > max) {
                winners.clear();
                max = players.get(i);
                winners.add(String.valueOf(player));
            } else if (players.get(i) == max) {
                winners.add(String.valueOf(player));
            }
        }
        String winner = String.join(", ", winners);
        System.out.println("Player " + winner + " wins!");

    }
}
