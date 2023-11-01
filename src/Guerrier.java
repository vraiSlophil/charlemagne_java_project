public class Guerrier {

    private String nom;
    private int pv;
    private Arc arc;

    public Guerrier(String nom) {
        this.nom = nom;
        this.pv = 10;
        this.arc = null;
    }

    public Guerrier(String pNom, int p) {
        this.nom = pNom;
        this.pv = Math.max(1, p);
        this.arc = null;
    }

    public boolean etreBlesse() {
        return (this.pv == 0);
    }

    public void subirDegat(int degat) {
        this.pv = Math.max(0, this.pv - degat);
    }

    public boolean prendreArc(Arc arc) {
        if (arc != null && this.arc == null && !this.etreBlesse()) {
            this.arc = arc;
            return true;
        }
        return false;
    }

    public Arc poserArc() {
        if (!this.etreBlesse()) {
            Arc arc = this.arc;
            this.arc = null;
            return arc;
        }
        return null;
    }

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

    public int getPv() {
        return pv;
    }

    public Arc getArc() {
        return arc;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        if (this.arc != null) {
            return this.nom + "(" + this.pv + ")" + this.arc.toString();
        }
        return this.nom + "(" + this.pv + ")";
    }


}