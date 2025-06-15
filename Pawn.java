public class Pawn implements Piece {
    Deck badDeck;
    String name;
    int pieceHealth;
    public Pawn() {
        badDeck = (new Deck(1));
        name = pickAdj() + " Pawn";
        pieceHealth = 10;
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
