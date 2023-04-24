/**
 * @author REMACLE Pascal
 *
 */

import java.util.concurrent.Semaphore;

public class Philosopher extends Thread {

	/*Variable*/
    private static final Semaphore semaphore = new Semaphore(1);

    private final int id;
    private final Fork leftFork;
    private final Fork rightFork;
    private boolean eat = false; // Variable vérifiant si le philosophe a mangé.

    /*Constructor*/
    public Philosopher(int id, Fork leftFork, Fork rightFork) {
        this.id = id + 1;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override //Class relative au Thread
    public void run() {
    	//Tant que les philosophes n'ont pas mangé
        while (!eat) {
            System.out.println("Philosopher " + id + " is thinking...");
            semaphore.acquireUninterruptibly();
            leftFork.take(id);
            System.out.println("Philosopher " + id + " took the left fork " + rightFork.id);
            rightFork.take(id);
            semaphore.release();
            System.out.println("Philosopher " + id + " took the right fork " + leftFork.id);
            System.out.println("Philosopher " + id + " is eating...");
            // Le philosophe i a mangé
            this.eat = true; 
            leftFork.put(id);
            System.out.println("Philosopher " + id + " has put down the left fork " + leftFork.id);
            rightFork.put(id);
            System.out.println("Philosopher " + id + " has put down the right fork " + rightFork.id);
        }       
    }
}