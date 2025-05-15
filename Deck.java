import java.util.ArrayList;
import java.util.Arrays;

public class Deck {
    ArrayList<Card> deck;

    public Deck() {
        deck = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            deck.add(new Card((i % 8) + 1));
        }
    }

    public String printDeck() {
        StringBuilder msg = new StringBuilder();
        for (int i = 0; i < deck.size() - 1; i++) {
            msg.append(deck.get(i)).append(", ");
        }
        msg.append(deck.get(deck.size() - 1));
        return msg.toString();
    }

    public void addCard(Card c) {
        deck.add(c);
    }
}
