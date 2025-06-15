public class King implements Piece{
    String name;
    Deck badDeck;
    int pieceHealth;
    public King() {
        name = pickAdj() + " King";
        badDeck = new Deck(6);
        pieceHealth = 30;
    }
    public int getPieceHealth() {
        return pieceHealth;
    }
    public String getName() {
        return name;
    }

    public Deck getDeck() {
        return badDeck;
    }

    public void takeDamage(int health) {
        pieceHealth -= health;
    }

    public String pickAdj() {
        return adjs[(int)(Math.random() * adjs.length)];
    }
}
