import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Deck {
    ArrayList<Card> deck;

    public Deck() {
        deck = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            deck.add(new Card((i % 8) + 1));
        }
        sort();
    }

    // 1 (Pawn) = Cards 4-1 (16 total); average card = 2.5
    // 2 (Knight) = Only 5s and 1s (16 total); average card = 3
    // 3 (Bishop) = One 8, one 7, two 6, two 5, two 4, two 3, three 2, three 1 (16 total); average card = 3.75
    // 4 (Rook) = Cards 5-2: one 5 and one 2 is actually an 8 (16 total); average card = 4.0625
    // 5 (Queen) = Cards 6-3 (16 total); average card = 4.5
    // 6 (King) = two 10, two 8, two 6, two 5, two 4, two 3, two 2, two 1; average card = 4.875
    public Deck(int pieceNumber) {
        switch (pieceNumber) {
            case 1:
                deck = new ArrayList<>();
                for (int i = 4; i >= 1; i--) {
                    for (int j = 0; j < 4; j++) {
                        deck.add(new Card(i));
                    }
                }
                break;
            case 2:
                deck = new ArrayList<>();
                for (int i = 0; i < 8; i++) {
                    deck.add(new Card(5));
                }
                for (int i = 0; i < 8; i++) {
                    deck.add(new Card(1));
                }
                break;
            case 3:
                deck = new ArrayList<>();
                deck.add(new Card(8));
                deck.add(new Card(7));
                for (int i = 6; i >= 3; i--) {
                    deck.add(new Card(i));
                    deck.add(new Card(i));
                }
                for (int i = 2; i >= 1; i--) {
                    deck.add(new Card(i));
                    deck.add(new Card(i));
                    deck.add(new Card(i));
                }
                break;
            case 4:
                deck = new ArrayList<>();
                deck.add(new Card(8));
                deck.add(new Card(8));
                for (int i = 0; i < 3; i++) {
                    deck.add(new Card(5));
                }
                for (int i = 0; i < 4; i++) {
                    deck.add(new Card(4));
                }
                for (int i = 0; i < 4; i++) {
                    deck.add(new Card(3));
                }
                for (int i = 0; i < 3; i++) {
                    deck.add(new Card(2));
                }
                break;
            case 5:
                deck = new ArrayList<>();
                for (int i = 6; i >= 3; i--) {
                    for (int j = 0; j < 4; j++) {
                        deck.add(new Card(i));
                    }
                }
                break;
            case 6:
                deck = new ArrayList<>();
                deck.add(new Card(10));
                deck.add(new Card(10));
                deck.add(new Card(8));
                deck.add(new Card(8));
                for (int i = 6; i >= 1; i--) {
                    deck.add(new Card(i));
                    deck.add(new Card(i));
                }
                break;
        }
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public String printDeck() {
        StringBuilder msg = new StringBuilder();
        for (int i = 0; i < deck.size() - 1; i++) {
            msg.append(deck.get(i)).append(", ");
        }
        msg.append(deck.get(deck.size() - 1));
        return msg.toString();
    }

    public Card getCard(int index) {
        return deck.get(index);
    }

    public void sort() {
        Collections.sort(deck, (c1, c2) -> Integer.compare(c2.getVal(), c1.getVal()));
    }

    public void addCard(Card c) {
        deck.add(c);
    }
}
