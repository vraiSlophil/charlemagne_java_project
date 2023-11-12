import static libtest.Lanceur.lancer;

public class ProgCombat {


    public ProgCombat() {
    }

    public static void main(String[] args) {

        tests(args);


        Guerrier legolas = new Guerrier("Legolas", 4);
        System.out.println(legolas);
        Guerrier orc = new Guerrier("Ugluk", 3);
        System.out.println(orc);

        legolas.attaquer(orc);
        System.out.println(legolas);
        System.out.println(orc);

        Arc arcElfique = new Arc(2, 1);
        legolas.prendreArc(arcElfique);
        System.out.println(legolas);

        for (int i = 0; i < 3; i++) {
            legolas.attaquer(orc);
            System.out.println(legolas);
            System.out.println(orc);
        }

        Arc orcArc = new Arc(5, 3);
        orc.prendreArc(orcArc);
        System.out.println(orc);

        orc.attaquer(legolas);
        System.out.println(legolas);
        System.out.println(orc);

        Guerrier arwen = new Guerrier("Arwen", 10);
        System.out.println(arwen);

        arwen.prendreArc(arcElfique);
        System.out.println(arwen);

        arcElfique.recharger(1);
        System.out.println(arcElfique);

        arwen.attaquer(orc);
        System.out.println(arwen);
        System.out.println(orc);

        orc.attaquer(arwen);
        System.out.println(arwen);
        System.out.println(orc);
    }

    private static void tests(String[] args) {
        new TestArc();
//        lancer(new TestArc(), args);
//        lancer(new TestGuerrier(), args);

    }

}
