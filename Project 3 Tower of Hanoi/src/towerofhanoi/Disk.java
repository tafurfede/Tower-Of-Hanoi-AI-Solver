package towerofhanoi;

import cs2.Shape;
import java.awt.Color;
import student.TestableRandom;

// -------------------------------------------------------------------------
/**
 * Represents a disk in the Tower of Hanoi game. A disk is a shape with a
 * certain width and color. It extends the Shape class and implements the
 * Comparable interface for comparison. Disks are created with a specific width
 * and a randomly generated color.
 * 
 * @author federicotafur
 * @version Mar 18, 2024
 */
public class Disk
    extends Shape
    implements Comparable<Disk>
{
    // ~ Fields ................................................................
    private int width;
    @SuppressWarnings("unused")
    private Color color;

    // ~ Constructors ..........................................................
    // ----------------------------------------------------------
    /**
     * Create a new Disk object with the specified width.
     * 
     * @param width
     *            The width of the disk.
     */
    public Disk(int width)
    {
        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);
        this.width = width;
        TestableRandom random = new TestableRandom();
        Color randomColor = new Color(
            random.nextInt(256),
            random.nextInt(256),
            random.nextInt(256));
        this.setBackgroundColor(randomColor);
    }


    // ~Public Methods ........................................................
    /**
     * Compares this disk with the specified disk for order. Returns a negative
     * integer, zero, or a positive integer as this disk is less than, equal to,
     * or greater than the specified disk.
     * 
     * @param otherDisk
     *            The disk to be compared.
     * @return A negative integer, zero, or a positive integer as this disk is
     *             less than, equal to, or greater than the specified disk.
     */
    public int compareTo(Disk otherDisk)
    {
        if (otherDisk == null)
        {
            throw new IllegalArgumentException("Cannot compare to null disk");
        }
        return this.getWidth() - otherDisk.getWidth();
    }


    /**
     * Returns the width of the disk.
     * 
     * @return The width of the disk.
     */
    public int getWidth()
    {
        return width;
    }


    /**
     * Returns a string representation of the disk, which is its width.
     * 
     * @return The string representation of the disk.
     */
    public String toString()
    {
        return Integer.toString(width);
    }


    /**
     * Indicates whether some other object is "equal to" this one.
     * 
     * @param obj
     *            The reference object with which to compare.
     * @return true if this object is the same as the obj argument; false
     *             otherwise.
     */
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        Disk otherDisk = (Disk)obj;
        return width == otherDisk.width;
    }

}
