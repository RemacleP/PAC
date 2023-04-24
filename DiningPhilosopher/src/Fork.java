/**
 * @author REMACLE Pascal
 *
 */
public class Fork {

	/*Variable*/
    public final int id; //Id unique pour chaque fourchette
    private boolean forkIsOnTheTable = true; //fourchette posée
    private int philosopherUsingThisFork; //Philosopher utilisant la fourchette

    
    /*Constructor*/
    public Fork(int id) {
        this.id = id + 1;
    }
    
    /*Methode take
     * @param: int philosopher -> id de philosopher
     * Permet de prendre la fourchette
     * */
    public synchronized void take(int philosopher) {

        while (!forkIsOnTheTable) {
            try {
                wait();
            }
            catch (InterruptedException e) {}
        }

        philosopherUsingThisFork = philosopher;

        forkIsOnTheTable = false;

    }
    
    /*Methode put
     * @param: int philosopher -> id de philosopher
     * Permet de deposer la fourchette
     * */
    public synchronized void put(int philosopher) {
    	
        if (!forkIsOnTheTable && philosopherUsingThisFork == philosopher) {
            forkIsOnTheTable = true;
            notify();
        }

    }

}