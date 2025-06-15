public class Rook implements Piece{
    Deck badDeck;
    String name;
    int pieceHealth;

    public Rook() {
        badDeck = new Deck(4);
        name = pickAdj() + " Rook";
        pieceHealth = 25;
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
