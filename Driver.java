import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Driver {
    public static boolean gameOver = false;
    public static boolean playerTurn = true;
    public static int health = 100;
    public static Piece[] enemies;
    public static int enemyIndex;
    public static ArrayList<Card> hand;
    public static Deck hero = new Deck();
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws InterruptedException {
        createEnemies();
        hand = new ArrayList<>();
        drawHand();
        while(!gameOver) {
            if (playerTurn) {
                displayPlayerHUD();
                attack();
            } else {
                enemyAttack();
            }
        }
    }

    public static void createEnemies() {
        Pawn pawn = new Pawn();
        Knight knight = new Knight();
        Bishop bishop = new Bishop();
        Rook rook = new Rook();
        Queen queen = new Queen();
        King king = new King();
        enemies = new Piece[]{pawn, knight, bishop, rook, queen, king};
        enemyIndex = 0;
    }

    public static void addSuspense() throws InterruptedException {
        System.out.println();
        for(int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            System.out.print(".");
        }
    }

    public static void displayPlayerHUD() {
        System.out.println("You!: " + health + " hp");
        System.out.println(enemies[enemyIndex].getName() + "!: " + enemies[enemyIndex].getPieceHealth() + " hp");
        System.out.println("HAND = " + hand);
    }

    public static void drawHand() {
        for (int i = 0; i < 5; i++) {
            hand.add(hero.getDeck().get((int) (Math.random() * hero.getDeck().size())));
        }
    }

    public static int getPlayerInput() {
        System.out.print("Choose a card to play: ");
        int ans = in.nextInt();
        while (getIndexOfCard(ans) == -1) {
            System.out.println("Select a card in your hand!");
            System.out.print("Choose a card to play: ");
            ans = in.nextInt();
        }
        return hand.remove(getIndexOfCard(ans)).getVal();
    }

    public static int getIndexOfCard(int cardVal) {
        int index = -1;
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).getVal() == cardVal) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void attack() throws InterruptedException {
        int playedCard = getPlayerInput();
        System.out.println("The " + enemies[enemyIndex].getName() + " takes "
                + playedCard + " points of damage!");
        enemies[enemyIndex].takeDamage(playedCard);
        hand.add(hero.getDeck().get((int) (Math.random() * hero.getDeck().size())));
        if (enemies[enemyIndex].getPieceHealth() <= 0) {
            System.out.println(enemies[enemyIndex++].getName() + " has been SLAIN!");
            if (enemyIndex == 6) {
                System.out.println("YOU WIN!");
                gameOver = true;
            } else {
                selectTrophy();
                System.out.println("A new challenger is approaching");
                addSuspense();
                System.out.println("Beware the " + enemies[enemyIndex].getName() + "!");
            }
        }
        playerTurn = false;
    }

    public static void selectTrophy() {
        System.out.println();
        System.out.println("Select a trophy for your win:\n" +
                "(1) Storm: Increase cards in hand by 1\n" +
                "(2) Castle: Heal for 5 hp\n" +
                "(3) Promote: Add one 10 to your deck\n");
        int ans = in.nextInt();
        while (ans > 3 || ans < 1) {
            System.out.println("Select an option...");
            System.out.println("Select a trophy for your win:\n" +
                    "(1) Storm: Increase cards in hand by 1\n" +
                    "(2) Castle: Heal for 5 hp\n" +
                    "(3) Promote: Add one 10 to your deck\n");
            ans = in.nextInt();
        }
        switch (ans) {
            case 1:
                for (int i = 0; i < hand.size(); i++) {
                    Card c = hand.get(i);
                    hand.get(i).setVal(c.getVal() + 1);
                }
                System.out.println("Stormed! Hand has been strengthened!");
                break;
            case 2:
                health += 10;
                if (health > 100) { health = 100; }
                System.out.println("Castled! Heal 5 health!");
                break;
            case 3:
                for (int i = 0; i < 3; i++) {
                    hero.addCard(new Card(10));
                }
                System.out.println("Promotion! +10");
                break;
        }
    }

    public static void enemyAttack() throws InterruptedException {
        System.out.println();
        int attackVal = enemies[enemyIndex].getDeck().getCard((int)(Math.random() * 16)).getVal();
        System.out.println("An attack is coming!");
        addSuspense();
        System.out.println("The " + enemies[enemyIndex].getName() + " attacks for " + attackVal + "!");
        health -= attackVal;
        if (health <= 0) {
            System.out.println("YOU DIED!");
            gameOver = true;
        }
        playerTurn = true;
    }

}
