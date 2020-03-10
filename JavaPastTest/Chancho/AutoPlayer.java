import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AutoPlayer extends AbstractPlayer {
    AutoPlayer(CardPile left, CardPile right, String name) {
        super(left, right, name);
    }

    @Override
    protected int selectCard() {
        List<Integer> chooseFrom = new ArrayList<>();

        for (int i = 0; i < cards.length; i++) {
            chooseFrom.add(i);
            for (int j = 0; j < cards.length; j++) {
                if (cards[i].getRank().compareTo(cards[j].getRank()) == 0 && i != j) {
                    chooseFrom.remove((Integer) i);
                }
            }
        }

        Random r = new Random();
        if (chooseFrom.size() == 0) {
            return r.nextInt(cards.length);
        } else {
            return chooseFrom.get(r.nextInt(chooseFrom.size()));
        }
    }
}