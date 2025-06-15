public class Knight implements Piece{
    Deck badDeck;
    String name;
    int pieceHealth;

    public Knight() {
        badDeck = new Deck(2);
        name = pickAdj() + " Knight";
        pieceHealth = 15;
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
