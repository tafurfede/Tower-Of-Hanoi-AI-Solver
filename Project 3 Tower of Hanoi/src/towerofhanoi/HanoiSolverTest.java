package towerofhanoi;

// -------------------------------------------------------------------------
/**
 * This class contains test cases for the HanoiSolver class. It tests the
 * functionality of methods in the HanoiSolver class such as disks(),
 * getTower(), toString(), move(), and solveTowers().
 * 
 * @author federicotafur
 * @version Mar 18, 2024
 */
public class HanoiSolverTest
    extends student.TestCase
{
    // ~ Fields ................................................................
    private HanoiSolver hanoiSolver;
    private Tower leftTower;
    private Tower middleTower;
    private Tower rightTower;

    // ~ Constructors ..........................................................
    /**
     * Sets up the test fixture.
     */
    public void setUp()
    {
        hanoiSolver = new HanoiSolver(5);
        leftTower = hanoiSolver.getTower(Position.LEFT);
        middleTower = hanoiSolver.getTower(Position.MIDDLE);
        rightTower = hanoiSolver.getTower(Position.RIGHT);
    }


    // ~Public Methods ........................................................
    /**
     * Test method for disks() in HanoiSolver class.
     */
    public void testDisks()
    {
        int expectedDisks = 5;

        int actualDisks = hanoiSolver.disks();

        assertEquals(expectedDisks, actualDisks);
    }


    /**
     * Test method for getTower() in HanoiSolver class.
     */
    public void testGetTower()
    {
        // Test getting the left tower
        assertNotNull(leftTower);
        assertEquals(Position.LEFT, leftTower.position());

        // Test getting the middle tower
        assertNotNull(middleTower);
        assertEquals(Position.MIDDLE, middleTower.position());

        // Test getting the right tower
        assertNotNull(rightTower);
        assertEquals(Position.RIGHT, rightTower.position());

        assertEquals(
            Position.MIDDLE,
            hanoiSolver.getTower(Position.UNKNOWN).position());
    }


    /**
     * Test method for toString() in HanoiSolver class.
     */
    public void testToString()
    {
        String expectedString = hanoiSolver.getTower(Position.LEFT).toString()
            + hanoiSolver.getTower(Position.MIDDLE).toString()
            + hanoiSolver.getTower(Position.RIGHT).toString();

        assertEquals(expectedString, hanoiSolver.toString());
    }


    // ----------------------------------------------------------
    /**
     * Test the solve method.
     */
    public void testSolve()
    {
        hanoiSolver.getTower(Position.LEFT).push(new Disk(5));
        assertEquals(1, hanoiSolver.getTower(Position.LEFT).size());
        Disk disk = new Disk(4);
        hanoiSolver.getTower(Position.LEFT).push(disk);
        hanoiSolver.getTower(Position.LEFT).push(new Disk(3));
        hanoiSolver.getTower(Position.LEFT).push(new Disk(2));
        hanoiSolver.getTower(Position.LEFT).push(new Disk(1));
        assertEquals(5, hanoiSolver.getTower(Position.LEFT).size());
        hanoiSolver.solve();
        
        assertEquals(0, hanoiSolver.getTower(Position.LEFT).size());
        assertEquals(0, hanoiSolver.getTower(Position.MIDDLE).size());
        assertEquals(5, hanoiSolver.getTower(Position.RIGHT).size());   
    }
}
