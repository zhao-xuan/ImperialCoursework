import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The class Dealer encapsulates the actions of a Chancho game-dealer. The game
 * dealer is responsible for dealing cards from the provided game-deck to each
 * player, and scheduling rounds of the game until a player has won the game.
 * All players who have declared themselves as a winner should be congratulated.
 * 
 * Developers should provide the constructor,
 * 
 * public Dealer(Set<Player> players, Deck gameDeck);
 * 
 */
public final class Dealer {
    private final Set<Player> players;
    private final Deck deck;

    public Dealer(Set<Player> players, Deck deck) {
        this.players = players;
        this.deck = deck;
        for (Player p : players) {
            for (int i = 0; i < 4; i++) {
                p.addToHand(deck.removeFromTop());
            }
        }
    }

    public void playGame() {
        while(true) {
            players.forEach(i -> i.discard());
            players.forEach(i -> i.pickup());
            List<Player> winners = players.stream().filter(i -> i.hasWon()).collect(Collectors.toList());
            if (!winners.isEmpty()) {
                congratulateWinners();
                break;
            }
        }
    }

    private void congratulateWinners() {
        System.out.println("The game has been won! Congratulations to:");
        players.stream().filter(i -> i.hasWon()).forEach(i -> System.out.println(i));
    }
}