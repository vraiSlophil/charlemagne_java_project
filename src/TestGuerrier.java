import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;


/**
 * Classe de test qui permet de verifier que la classe Guerrier est correcte
 */
public class TestGuerrier {

	/**
	 * methode de lancement des tests
	 *
	 * @param args non utilise
	 */
	public static void main(String[] args) {
		lancer(new TestGuerrier(), args);
	}

	/**
	 * test des methodes de guerrier
	 */
	public void test_guerrier_methodes() {
		Guerrier guerrier = new Guerrier("Toto",10);
		int pv = guerrier.getPv();
		Arc arc = guerrier.getArc();
		String nom = guerrier.getNom();

		boolean b = guerrier.etreBlesse();
		guerrier.subirDegat(1);

		Arc arcN = new Arc();
		boolean resPrendre = guerrier.prendreArc(arcN);
		Arc resPoser = guerrier.poserArc();

		Guerrier victime = new Guerrier("vict");
		boolean resAttaque = guerrier.attaquer(victime);

		String guerrierS = guerrier.toString();
	}


	/**
	 * quand le guerrier est cree avec un nom
	 */
	// @Test
	public void test_GuerrierConstructeurNom() {
		Guerrier guerrier = new Guerrier("Toto");
		String nom = guerrier.getNom();
		assertEquals("le nom du guerrier est incorrect", "Toto", nom);
		assertEquals("le guerrier doit avoir 10 pv", 10, guerrier.getPv());
		assertEquals("le guerrier ne doit pas avoir d'arc", null, guerrier.getArc());
	}

	/**
	 * quand le guerrier est cree avec un nom et un nombre de pv
	 */
	// @Test
	public void test_GuerrierConstructeurPv() {
		Guerrier guerrier = new Guerrier("Toto", 5);
		String nom = guerrier.getNom();
		assertEquals("le nom du guerrier est incorrect", "Toto", nom);
		assertEquals("le guerrier doit avoir 5 pv", 5, guerrier.getPv());
		assertEquals("le guerrier ne doit pas avoir d'arc", null, guerrier.getArc());
	}

	/**
	 * quand le guerrier est cree avec un nom et un nombre de pv negatif
	 */
	// @Test
	public void test_GuerrierConstructeurPvNegatif() {
		Guerrier guerrier = new Guerrier("Toto", -5);
		String nom = guerrier.getNom();
		assertEquals("le nom du guerrier est incorrect", "Toto", nom);
		assertEquals("le guerrier doit avoir 1 pv", 1, guerrier.getPv());
		assertEquals("le guerrier ne doit pas avoir d'arc", null, guerrier.getArc());
	}


	/**
	 * quand le guerrier subit des degats
	 */
	// @Test
	public void test_SubirDegat() {
		Guerrier guerrier = new Guerrier("Toto", 5);
		guerrier.subirDegat(2);
		assertEquals("le guerrier doit avoir 3 pv", 3, guerrier.getPv());
	}

	/**
	 * quand le guerrier est blesse
	 */
	// @Test
	public void test_EtreBlesseBlesse() {
		Guerrier guerrier = new Guerrier("Toto", 5);
		guerrier.subirDegat(5);
		boolean blesse = guerrier.etreBlesse();
		assertEquals("le guerrier doit etre blesse", true, blesse);
	}

	/**
	 * quand le guerrier n'est pas blesse
	 */
	// @Test
	public void test_EtreBlesse() {
		Guerrier guerrier = new Guerrier("Toto", 5);
		boolean blesse = guerrier.etreBlesse();
		assertEquals("le guerrier ne doit pas etre blesse", false, blesse);
	}

	/**
	 * quand le guerrier prend un arc
	 */
	// @Test
	public void test_PrendreArcOK() {
		Guerrier guerrier = new Guerrier("Toto", 5);
		Arc arc = new Arc();
		boolean res = guerrier.prendreArc(arc);
		assertEquals("le guerrier doit prendre l'arc", true, res);
		assertEquals("le guerrier doit avoir l'arc", arc, guerrier.getArc());
	}



	/**
	 * quand le guerrier prend un arc alors qu'il est blesse
	 */
	// @Test
	public void test_PrendreArcBlesse() {
		Guerrier guerrier = new Guerrier("Toto", 5);
		guerrier.subirDegat(5);
		Arc arc = new Arc();
		boolean res = guerrier.prendreArc(arc);
		assertEquals("le guerrier ne doit pas prendre l'arc", false, res);
		assertEquals("le guerrier ne doit pas avoir d'arc", null, guerrier.getArc());
	}

	/**
	 * quand le guerrier prend un arc alors qu'il a deja un arc
	 */
	// @Test
	public void test_PrendreArcDejaArc() {
		Guerrier guerrier = new Guerrier("Toto", 5);
		Arc arc = new Arc();
		guerrier.prendreArc(arc);
		Arc arc2 = new Arc();
		boolean res = guerrier.prendreArc(arc2);
		assertEquals("le guerrier ne doit pas prendre l'arc", false, res);
		assertEquals("le guerrier doit avoir l'arc", arc, guerrier.getArc());
	}

	/**
	 * quand le guerrier prend un arc null
	 */
	// @Test
	public void test_PrendreArcNull() {
		Guerrier guerrier = new Guerrier("Toto", 5);
		boolean res = guerrier.prendreArc(null);
		assertEquals("le guerrier ne doit pas prendre l'arc", false, res);
		assertEquals("le guerrier ne doit pas avoir d'arc", null, guerrier.getArc());
	}

	/**
	 * quand le guerrier pose son arc
	 */
	// @Test
	public void test_PoserArcOK() {
		Guerrier guerrier = new Guerrier("Toto", 5);
		Arc arc = new Arc();
		guerrier.prendreArc(arc);
		Arc res = guerrier.poserArc();
		assertEquals("le guerrier doit poser l'arc", arc, res);
		assertEquals("le guerrier ne doit pas avoir d'arc", null, guerrier.getArc());
	}

	/**
	 * quand le guerrier pose son arc alors qu'il est blesse
	 */
	// @Test
	public void test_PoserArcBlesse() {
		Guerrier guerrier = new Guerrier("Toto", 5);
		Arc arc = new Arc();
		guerrier.prendreArc(arc);
		guerrier.subirDegat(5);
		Arc res = guerrier.poserArc();
		assertEquals("le guerrier ne doit pas poser l'arc", null, res);
		assertEquals("le guerrier doit avoir son arc", arc, guerrier.getArc());
	}

	/**
	 * quand le guerrier pose son arc alors qu'il n'a pas d'arc
	 */
	// @Test
	public void test_PoserArcPasArc() {
		Guerrier guerrier = new Guerrier("Toto", 5);
		Arc res = guerrier.poserArc();
		assertEquals("le guerrier ne doit pas poser l'arc", null, res);
		assertEquals("le guerrier ne doit pas avoir d'arc", null, guerrier.getArc());
	}

	/**
	 * quand le guerrier attaque un autre guerrier
	 */
	// @Test
	public void test_AttaquerOK() {
		Guerrier guerrier = new Guerrier("Toto", 5);
		Arc arc = new Arc();
		guerrier.prendreArc(arc);
		Guerrier victime = new Guerrier("Victime", 7);
		boolean res = guerrier.attaquer(victime);
		assertEquals("le guerrier doit attaquer", true, res);
		assertEquals("la victime doit avoir 2 pv", 2, victime.getPv());
		assertEquals("le guerrier doit avoir 2 fleches", 2, arc.getFleches());
	}

	/**
	 * quand le guerrier attaque un autre guerrier alors qu'il est blesse
	 */
	// @Test
	public void test_AttaquerBlesse() {
		Guerrier guerrier = new Guerrier("Toto", 5);
		guerrier.subirDegat(5);
		Arc arc = new Arc();
		guerrier.prendreArc(arc);
		Guerrier victime = new Guerrier("Victime", 5);
		boolean res = guerrier.attaquer(victime);
		assertEquals("le guerrier ne doit pas attaquer", false, res);
		assertEquals("la victime doit avoir 5 pv", 5, victime.getPv());
		assertEquals("le guerrier doit avoir 3 fleches", 3, arc.getFleches());
	}

	/**
	 * quand le guerrier attaque un autre guerrier alors qu'il n'a pas d'arc
	 */
	// @Test
	public void test_AttaquerPasArc() {
		Guerrier guerrier = new Guerrier("Toto", 5);
		Guerrier victime = new Guerrier("Victime", 5);
		boolean res = guerrier.attaquer(victime);
		assertEquals("le guerrier ne doit pas attaquer", false, res);
		assertEquals("la victime doit avoir 5 pv", 5, victime.getPv());
	}

	/**
	 * quand le guerrier attaque un autre guerrier alors qu'il n'a plus de fleches
	 */
	// @Test
	public void test_AttaquerPlusFleches() {
		Guerrier guerrier = new Guerrier("Toto", 5);
		Arc arc = new Arc();
		guerrier.prendreArc(arc);
		for (int i = 0; i < 4; i++) {
			arc.utiliser();
		}
		Guerrier victime = new Guerrier("Victime", 5);
		boolean res = guerrier.attaquer(victime);
		assertEquals("le guerrier ne doit pas attaquer", false, res);
		assertEquals("la victime doit avoir 5 pv", 5, victime.getPv());
		assertEquals("le guerrier doit avoir 0 fleches", 0, arc.getFleches());
	}

	/**
	 * Verification de la méthode toString de la classe Guerrier
	 */
	public void test_ToStringSansArc() {
		Guerrier guerrier = new Guerrier("Toto");
		assertEquals("la conversion en string n'est pas bonne", "Toto(10)", guerrier.toString());
	}

	/**
	 * Verification de la méthode toString de laclasse Guerrier
	 */
	public void test_ToStringAvecArc() {
		Guerrier guerrier = new Guerrier("Toto");
		Arc arc = new Arc();

		guerrier.prendreArc(arc);

		assertEquals("la conversion en string n'est pas bonne", "Toto(10)" + arc, guerrier.toString());
	}

}
