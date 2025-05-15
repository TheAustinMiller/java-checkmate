public class Card {
    private int val;

    public Card(int val) {
        this.val = val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public int getVal() { return this.val; }

    @Override
    public String toString() {
        return val + "";
    }
}
