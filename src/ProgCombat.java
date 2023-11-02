public class ProgCombat {


    public ProgCombat() {
    }

    public void execute() {
        Guerrier legolas = new Guerrier("Legolas", 4);
        System.out.println(legolas);
        Guerrier ugluk = new Guerrier("Ugluk", 3);
        System.out.println(ugluk);

        legolas.attaquer(ugluk);
        System.out.println(legolas);
        System.out.println(ugluk);

        Arc arcElfique = new Arc(2, 1);
        legolas.prendreArc(arcElfique);
        System.out.println(legolas);

        for (int i = 0; i < 3; i++) {
            legolas.attaquer(ugluk);
            System.out.println(legolas);
            System.out.println(ugluk);
        }

        Arc orcArc = new Arc(5, 3);
        ugluk.prendreArc(orcArc);
        System.out.println(ugluk);

        ugluk.attaquer(legolas);
        System.out.println(legolas);
        System.out.println(ugluk);

        Guerrier arwen = new Guerrier("Arwen", 10);
        System.out.println(arwen);

        arwen.prendreArc(arcElfique);
        System.out.println(arwen);

        arcElfique.recharger(1);
        System.out.println(arcElfique);

        arwen.attaquer(ugluk);
        System.out.println(arwen);
        System.out.println(ugluk);

        ugluk.attaquer(arwen);
        System.out.println(arwen);
        System.out.println(ugluk);
    }
}
