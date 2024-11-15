package towerofhanoi;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author federicotafur
 * @version Mar 18, 2024
 */
public class ProjectRunner
{
    // ~ Fields ................................................................

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................
    public static void main(String[] args)
    {
        // Default number of disks
        int disks = 6;

        // Check if an argument is provided
        if (args.length == 1)
        {
            try
            {
                // Parse the argument as an integer
                disks = Integer.parseInt(args[0]);
            }
            catch (NumberFormatException e)
            {
                // Handle invalid input gracefully (optional)
                System.out.println(
                    "Invalid input for number of disks. Using default value.");
            }
        }

        // Create a new HanoiSolver with the specified number of disks
        HanoiSolver hanoiSolver = new HanoiSolver(disks);

        // Create a new PuzzleWindow and pass the HanoiSolver to it
        PuzzleWindow puzzleWindow = new PuzzleWindow(hanoiSolver);
    }
}
