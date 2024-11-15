package towerofhanoi;

import java.util.Observable;

// -------------------------------------------------------------------------
/**
 * This class represents a solver for the Tower of Hanoi puzzle. It uses the
 * recursive approach to solve the puzzle efficiently. The class extends
 * Observable to allow observation of tower movements. To use this class, create
 * an instance with the desired number of disks, then call the solve() method to
 * solve the Tower of Hanoi puzzle. Observers can be added to the solver to
 * track tower movements.
 * 
 * @author federicotafur
 * @version Mar 18, 2024
 */
@SuppressWarnings("deprecation")
public class HanoiSolver
    extends Observable

{
    // ~ Fields ................................................................
    private Tower left;
    private Tower middle;
    private Tower right;
    private int numDisks;

    // ~ Constructors ..........................................................
    /**
     * Create a new HanoiSolver object with the specified number of disks.
     * 
     * @param numDisks
     *            The number of disks in the Tower of Hanoi puzzle.
     */
    public HanoiSolver(int numDisks)
    {
        this.numDisks = numDisks;
        this.left = new Tower(Position.LEFT);
        this.middle = new Tower(Position.MIDDLE);
        this.right = new Tower(Position.RIGHT);
    }


    // ~Public Methods ........................................................
    // ----------------------------------------------------------
    /**
     * Returns the number of disks in the Tower of Hanoi puzzle.
     * 
     * @return The number of disks.
     */
    public int disks()
    {
        return numDisks;
    }


    // ----------------------------------------------------------
    /**
     * Returns the tower at the specified position.
     * 
     * @param pos
     *            The position of the tower (LEFT, MIDDLE, or RIGHT).
     * @return The tower at the specified position.
     */
    public Tower getTower(Position pos)
    {
        switch (pos)
        {
            case LEFT:
                return left;
            case MIDDLE:
                return middle;
            case RIGHT:
                return right;
            default:
                // For testing purposes, return the middle tower in default case
                return middle;
        }
    }


    /**
     * Returns a string representation of the towers' state.
     * 
     * @return A string representation of the towers' state.
     */
    public String toString()
    {
        return left.toString() + middle.toString() + right.toString();
    }


    // ----------------------------------------------------------
    /**
     * Moves a disk from the source tower to the destination tower. Notifies
     * observers about the movement.
     * 
     * @param source
     *            The tower from which to move the disk.
     * @param destination
     *            The tower to which to move the disk.
     */
    private void move(Tower source, Tower destination)
    {
        Disk disk = source.pop();
        destination.push(disk);

        setChanged();
        notifyObservers(destination.position());
    }


    // ----------------------------------------------------------
    /**
     * Recursively solves the Tower of Hanoi puzzle.
     * 
     * @param currentDisks
     *            The number of disks to move.
     * @param startPole
     *            The tower representing the starting position.
     * @param tempPole
     *            The tower representing the temporary position.
     * @param endPole
     *            The tower representing the ending position.
     */
    private void solveTowers(
        int currentDisks,
        Tower startPole,
        Tower tempPole,
        Tower endPole)
    {
        if (currentDisks == 1)
        {
            move(startPole, endPole);
        }
        else
        {
            solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            move(startPole, endPole);
            solveTowers(currentDisks - 1, tempPole, startPole, endPole);
        }
    }


    // ----------------------------------------------------------
    /**
     * Solves the Tower of Hanoi puzzle. Calls the solveTowers method to
     * initiate the solving process.
     */
    public void solve()
    {
        solveTowers(numDisks, left, middle, right);
    }

}
