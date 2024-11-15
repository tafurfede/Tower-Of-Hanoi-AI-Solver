package towerofhanoi;

// -------------------------------------------------------------------------
/**
 * Represents a tower in the Tower of Hanoi puzzle. This class extends
 * LinkedStack and inherits its functionality to handle disks. Towers have a
 * position and can push disks onto them.
 * 
 * @author federicotafur
 * @version Mar 18, 2024
 */
public class Tower
    extends LinkedStack<Disk>
{
    // ~ Fields ................................................................
    private Position position;

    // ~ Constructors ..........................................................
    /**
     * Create a new Tower object with the specified position.
     * 
     * @param position
     *            The position of the tower (LEFT, MIDDLE, RIGHT).
     */
    public Tower(Position position)
    {
        super();
        this.position = position;
    }


    // ~Public Methods ........................................................
    /**
     * Pushes a disk onto the tower.
     * 
     * @param disk
     *            The disk to be pushed onto the tower.
     * @throws IllegalStateException
     *             if the disk being pushed is larger than the top disk on the
     *             tower.
     */
    public void push(Disk disk)
    {
        if (disk == null)
        {
            throw new IllegalArgumentException();
        }
        else if (this.isEmpty() || peek().compareTo(disk) > 0)
        {
            super.push(disk);
        }
        else
        {
            throw new IllegalStateException();
        }

    }


    // ----------------------------------------------------------
    /**
     * Gets the position of the tower.
     * 
     * @return The position of the tower (LEFT, MIDDLE, RIGHT).
     */
    public Position position()
    {
        return position;
    }

}
