public class Arc {
    private int degats;
    private int fleches;

    public Arc() {
        this.degats = 5;
        this.fleches = 3;
    }

    public Arc(int dg, int fl) {
        this.degats = dg;
        this.fleches = fl;
    }

    public void recharger(int nFleches) {
        if (nFleches > 0) {
            this.fleches += nFleches;
        }
    }

    public int utiliser() {
        if (this.fleches > 0) {
            this.fleches--;
            return this.degats;
        }
        return 0;
    }

    public int getDegats() {
        return degats;
    }

    public int getFleches() {
        return fleches;
    }

    @Override
    public String toString() {
        return "-arc(d: " + degats + ", f:" + fleches + ')';
    }
}