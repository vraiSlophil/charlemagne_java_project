import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;

/**
 * Class de test qui permet de verifier que la classe Arc est correcte
 */
public class TestArc {

	/**
	 * methode de lancement des tests
	 */
	public static void main(String[] args) {
		lancer(new TestArc(), args);
	}

	/**
	 * verifieque les méthodes sont bien appelée
	 */
	public void test_ArcConstructeur() {
		Arc arc = new Arc(3,5);
		assertEquals("ordre parametres est mauvais",3,arc.getDegats());
		assertEquals("ordre parametres est mauvais",5,arc.getFleches());
	}

	/**
	 *  quand l'arc est construit avec des parametres negatifs
	 */

	public void test_ArcConstructeurNegatif() {
		Arc arc = new Arc(-3,-5);
		assertEquals("arc doit faire 0 degats", 0, arc.getDegats());
		assertEquals("arc doit avoir 0 fleches", 0, arc.getFleches());
	}

	/**
	 * quand l'arc est recharge correctement
	 */
	public void test_RechargerOK() {
		// preparation des donnees
		Arc arc = new Arc(3,5);

		// methode testee
		arc.recharger(2);

		// verifications
		assertEquals("arc doit toujours faire 3 degats", 3, arc.getDegats());
		assertEquals("arc doit avoir 7 fleches", 7, arc.getFleches());
	}

	/**
	 * quand l'arc est recharge avec un nombre de fleches negatif
	 */
	public void test_RechargerNegatif() {
		// preparation des donnees
		Arc arc = new Arc(3,5);

		// methode testee
		arc.recharger(-2);

		// verifications
		assertEquals("arc doit toujours faire 3 degats", 3, arc.getDegats());
		assertEquals("arc doit toujours avoir 5 fleches", 5, arc.getFleches());
	}


	/**
	 * quand l'arc est utilise correctement
	 */
	public void test_UtilisterOK() {
		// preparation des donnees
		Arc arc = new Arc(3,5);

		// methode testee
		int dg = arc.utiliser();

		// verifications
		assertEquals("arc doit toujours faire 3 degats", 3, arc.getDegats());
		assertEquals("arc doit avoir 4 fleches", 4, arc.getFleches());
		assertEquals("arc doit faire 3 degats", 3, dg);
	}

	/**
	 * quand l'arc est utilise avec 0 fleche
	 */
	public void test_UtilisterZeroFleche() {
		// preparation des donnees
		Arc arc = new Arc(3,0);

		// methode testee
		int dg = arc.utiliser();

		// verifications
		assertEquals("arc doit toujours faire 3 degats", 3, arc.getDegats());
		assertEquals("arc doit avoir 0 fleches", 0, arc.getFleches());
		assertEquals("arc doit faire 0 degats", 0, dg);
	}


	/**
	 * Verification de la méthode toString de la classe Arc
	 */
	public void test_ToString() {
		Arc arc = new Arc(3, 5);
		assertEquals("la conversion en string n'est pas bonne", "-arc(d:3,f:5)", arc.toString());
	}




}