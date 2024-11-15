package towerofhanoi;

// -------------------------------------------------------------------------
/**
 * This class contains test cases for the Disk class. It tests the functionality
 * of methods in the Disk class such as getWidth(), toString(), equals(), and
 * compareTo().
 * 
 * @author federicotafur
 * @version Mar 18, 2024
 */
public class DiskTest
    extends student.TestCase
{
    // ~ Fields ................................................................

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................
    /**
     * Test method for getWidth method in Disk Class
     */
    public void testGetWidth()
    {
        Disk disk = new Disk(5);
        assertEquals(5, disk.getWidth());
    }


    // ----------------------------------------------------------
    /**
     * Test method for toString method in Disk Class
     */
    public void testToString()
    {
        Disk disk = new Disk(5);
        assertEquals("5", disk.toString());
    }


    // ----------------------------------------------------------
    /**
     * Test method for equals method in Disk Class
     */
    public void testEquals()
    {
        Disk disk1 = new Disk(5);
        Disk disk2 = new Disk(5);
        Disk disk3 = new Disk(10);
        assertTrue(disk1.equals(disk2));
        assertFalse(disk1.equals(disk3));
    }


    // ----------------------------------------------------------
    /**
     * Test method for compare method in Disk Class
     */
    public void testCompareToNull()
    {
        Disk disk = new Disk(5);
        Disk otherDisk = null;
        Exception exception = null;
        try
        {
            disk.compareTo(otherDisk);
        }
        catch (IllegalArgumentException e)
        {
            exception = e;
        }
        assertNotNull(exception);
    }


    // ----------------------------------------------------------
    /**
     * Test method for compare method in Disk Class
     */
    public void testCompareTo()
    {
        Disk disk1 = new Disk(5);
        Disk disk2 = new Disk(10);
        Disk disk3 = new Disk(15);
        // Assert disk1 == disk1
        assertEquals(0, disk1.compareTo(disk1));

        // Assert disk2 == disk2
        assertEquals(0, disk2.compareTo(disk2));

        // Assert disk3 == disk3
        assertEquals(0, disk3.compareTo(disk3));
    }


    // ----------------------------------------------------------
    /**
     * Test method for equals method in Disk Class
     */
    public void testEqualsSameObject()
    {
        Disk disk1 = new Disk(5);
        assertTrue(disk1.equals(disk1));
    }


    // ----------------------------------------------------------
    /**
     * Test method for equals method in Disk Class
     */
    public void testEqualsNullObject()
    {
        Disk disk1 = new Disk(5);
        assertFalse(disk1.equals(null));
    }


    // ----------------------------------------------------------
    /**
     * Test method for equals method in Disk Class
     */
    public void testEqualsDifferentClass()
    {
        Disk disk1 = new Disk(5);
        assertFalse(disk1.equals("Not a Disk object"));
    }


    // ----------------------------------------------------------
    /**
     * Test method for equals method in Disk Class
     */
    public void testEqualsSameWidth()
    {
        Disk disk1 = new Disk(5);
        Disk disk2 = new Disk(5);
        assertTrue(disk1.equals(disk2));
    }


    // ----------------------------------------------------------
    /**
     * Test method for equals method in Disk Class
     */
    public void testEqualsDifferentWidth()
    {
        Disk disk1 = new Disk(5);
        Disk disk2 = new Disk(10);
        assertFalse(disk1.equals(disk2));
    }
}
