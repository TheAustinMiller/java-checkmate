public class Bishop implements Piece{
    Deck badDeck;
    String name;
    int pieceHealth;

    public Bishop() {
        badDeck = new Deck(3);
        name = pickAdj() + " Bishop";
        pieceHealth = 20;
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
