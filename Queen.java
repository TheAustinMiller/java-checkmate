public class Queen implements Piece{
    String name;
    Deck badDeck;
    int pieceHealth;

    public Queen() {
        badDeck = new Deck(5);
        name = pickAdj() + " Queen";
        pieceHealth = 30;
    }
    public Deck getDeck() {
        return badDeck;
    }

    public int getPieceHealth() {
        return pieceHealth;
    }
    public String getName() {
        return name;
    }

    public void takeDamage(int health) {
        pieceHealth -= health;
    }


    public String pickAdj() {
        return adjs[(int)(Math.random() * adjs.length)];
    }
}
