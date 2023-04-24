/**
 * @author REMACLE Pascal
 *
 */

public class Application {
	
	public final static int numberPhilosopher = 5;
	
	/*Methode de création de philosophes
	 * @param n le nombre de philosophe
	 * */
	public static Philosopher[] createPhilosophers(int n) {
		/*Création des fourchettes*/
        Fork[] forks = new Fork[n];

        for (int i = 0; i < n; i++) {
            forks[i] = new Fork(i);
        }
        //Création des philosophes
        Philosopher[] philosophers = new Philosopher[n];
        //Création des fourchettes gauche et droite
        for (int i = 0; i < n; i++) {

            Fork leftFork = forks[i];
            Fork rightFork = forks[(i + 1) % n];

            philosophers[i] = new Philosopher(i, leftFork, rightFork);

        }

        return philosophers;

    }
	
	/*Methode de déclanchement de l'application*/
	public static void starting() {
		
		System.out.println("Application Starting! \n");
		Philosopher[] philosophers = createPhilosophers(numberPhilosopher);
	
	    for (Philosopher philosopher : philosophers) {
	        philosopher.start();
	    }
	    
	}
	
}
