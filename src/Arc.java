/**
 * Classe Arc, elle représente un arc
 */
public class Arc {
    private int degats;
    private int fleches;

    /**
     * Constructeur par défaut de la classe Arc
     */
    public Arc() {
        this.degats = 5;
        this.fleches = 3;
    }

    /**
     * Constructeur de la classe Arc
     *
     * @param dg    nombre de dégats de l'arc
     * @param fl    nombre de flèches de l'arc
     */
    public Arc(int dg, int fl) {
        this.degats = Math.max(0, dg);
        this.fleches = Math.max(0, fl);
    }

    /**
     * Méthode qui permet de recharger l'arc
     *
     * @param nFleches  nombre de flèches à recharger
     */
    public void recharger(int nFleches) {
        if (nFleches > 0) {
            this.fleches += nFleches;
        }
    }

    /**
     * Méthode qui permet d'utiliser l'arc
     *
     * @return  nombre de dégats de l'arc
     */
    public int utiliser() {
        if (this.fleches > 0) {
            this.fleches--;
            return this.degats;
        }
        return 0;
    }

    /**
     * Méthode qui permet de récupérer le nombre de dégats de l'arc
     *
     * @return  nombre de dégats de l'arc
     */
    public int getDegats() {
        return this.degats;
    }

    /**
     * Méthode qui permet de récupérer le nombre de flèches de l'arc
     *
     * @return  nombre de flèches de l'arc
     */
    public int getFleches() {
        return this.fleches;
    }

    /**
     * Méthode qui permet de récupérer la représentation de l'arc
     *
     * @return  représentation de l'arc
     */
    @Override
    public String toString() {
        return "-arc(d:" + degats + ",f:" + fleches + ')';
    }
}