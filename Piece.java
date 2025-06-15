import java.util.ArrayList;

public interface Piece {
    String[] adjs = {"Funny", "Silly", "Stupid", "Colorful", "Tired", "Cheesy", "Bashful", "Trippy", "Dorky",
            "Brilliant", "Arrogant", "Legendary", "Ostentatious", "Magnanimous", "Smelly", "Exciting", "Tall", "Short",
            "Mean", "Ugly", "Beautiful", "Thought-provoking", "Cat-like", "Brotherly", "Jumpy", "Grumpy", "Fuzzy",
            "Itchy", "Tactful", "Hapless", "Spicy", "Hot", "Cold", "Lukewarm", "Foreign", "Boastful", "Angry",
            "Determined", "Hateful", "Trashy", "Bonkers", "Prevalent", "Punctual", "Diligent", "Diseased", "Punchy",
            "Friendly",  "Thoughtless", "Pious", "Dirty", "Clean", "Titanic", "Wooden", "Marble", "Clay",
            "Faceless", "Anonymous", "Baseless", "Heartless", "Nerdy", "Clammy", "Conniving", "Nocturnal", "Crystal",
            "Quilted", "Risky", "Brash", "Dumb", "Goofy", "Tenacious", "Drunken", "Opulent", "Baroque", "Artisan",
            "Frozen", "Royal", "Pernicious", "Bloody", "Undercover", "Loud", "Trite", "Vapid", "Boring", "Top-heavy",
            "Silent", "Blood-thirsty", "Loquacious", "Vengeful", "Virulent", "Viscous", "Verile", "Brave", "Abstract",
            "Common", "Unique", "Hearty", "Sugary", "Salty", "Redneck", "Ravenous", "Annoying", "Stern", "Dark"};
    Deck badDeck = null;
    String name = "";
    Deck getDeck();
    int pieceHealth = 0;
    public void takeDamage(int health);
    public String pickAdj();
    public int getPieceHealth();
    public String getName();
}
