/**
 * Classe Guerrier, elle représente un guerrier
 */

public class Guerrier {

    private String nom;
    private int pv;
    private Arc arc;

    /**
     * Constructeur de la classe Guerrier avec des PV par défaut
     *
     * @param pNom  nom du guerrier
     */

    public Guerrier(String pNom) {
        this.nom = pNom;
        this.pv = 10;
        this.arc = null;
    }

    /**
     * Constructeur de la classe Guerrier avec des PV définis
     *
     * @param pNom  nom du guerrier
     * @param p     nombre de PV du guerrier
     */
    public Guerrier(String pNom, int p) {
        this.nom = pNom;
        this.pv = Math.max(1, p);
        this.arc = null;
    }

    /**
     * Méthode qui permet de savoir si le guerrier est blessé
     * @return true si le guerrier est blessé, false sinon
     */
    public boolean etreBlesse() {
        return (this.pv <= 0);
    }

    /**
     * Méthode qui permet de faire subir des dégats au guerrier
     * @param degat nombre de dégats subis
     */
    public void subirDegat(int degat) {
        this.pv = Math.max(0, this.pv - degat);
    }

    /**
     * Méthode qui permet de prendre un arc
     * @param arc   arc à prendre
     * @return true si l'arc est pris, false sinon
     */
    public boolean prendreArc(Arc arc) {
        if (arc != null && this.arc == null && !this.etreBlesse()) {
            this.arc = arc;
            return true;
        }
        return false;
    }

    /**
     * Méthode qui permet de poser l'arc
     * @return l'arc posé
     */
    public Arc poserArc() {
        if (!this.etreBlesse()) {
            Arc arc = this.arc;
            this.arc = null;
            return arc;
        }
        return null;
    }

    /**
     * Méthode qui permet d'attaquer un guerrier
     * @param victime   guerrier à attaquer
     * @return true si l'attaque a réussi, false sinon
     */
    public boolean attaquer(Guerrier victime) {
        if (victime != null && this.arc != null && !this.etreBlesse()) {
            int degat = this.arc.utiliser();
            if (degat <= 0) {
                return false;
            }
            victime.subirDegat(degat);
            return true;
        }
        return false;
    }

    /**
     * Méthode qui permet de récupérer les PV du guerrier
     * @return les PV du guerrier
     */
    public int getPv() {
        return pv;
    }

    /**
     * Méthode qui permet de récupérer l'arc du guerrier
     * @return l'arc du guerrier
     */
    public Arc getArc() {
        return arc;
    }

    /**
     * Méthode qui permet de récupérer le nom du guerrier
     * @return le nom du guerrier
     */
    public String getNom() {
        return nom;
    }

    /**
     * Méthode qui permet de récupérer la représentation du guerrier
     * @return la représentation du guerrier
     */
    @Override
    public String toString() {
        if (this.arc != null) {
            return this.nom + "(" + this.pv + ")" + this.arc;
        }
        return this.nom + "(" + this.pv + ")";
    }


}