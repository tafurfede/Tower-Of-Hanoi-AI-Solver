package towerofhanoi;

import cs2.Button;
import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author federicotafur
 * @version Mar 18, 2024
 */
public class PuzzleWindow
    implements Observer
{
    // ~ Fields ................................................................
    private HanoiSolver game;
    private Shape left;
    private Shape middle;
    private Shape right;
    private Window window;

    public static final int WIDTH_FACTOR = 15;
    public static final int DISK_GAP = 0;
    public static final int DISK_HEIGHT = 15;
    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................
    // ----------------------------------------------------------
    /**
     * Create a new PuzzleWindow object.
     * 
     * @param g
     */
    public PuzzleWindow(HanoiSolver g)
    {
        this.game = g;
        game.addObserver(this);
        window = new Window("Tower of Hanoi");
        int x = window.getGraphPanelWidth();
        int y = window.getGraphPanelHeight() / 2;

        left = new Shape(x / 6, y, 3, 90, Color.BLACK);
        middle = new Shape(x / 2, y, 3, 90, Color.BLACK);
        right = new Shape((x * 5) / 6, y, 3, 90, Color.BLACK);

        for (int i = game.disks(); i >= 1; i--)
        {
            Disk disc = new Disk(i * 6);
            window.addShape(disc);
            game.getTower(Position.LEFT).push(disc);
            moveDisk(Position.LEFT);

        }

        window.addShape(left);
        window.addShape(middle);
        window.addShape(right);
        Button solveButton = new Button("Solve");
        solveButton.onClick(this, "clickedSolve");
        window.addButton(solveButton, WindowSide.SOUTH);
    }


    private void moveDisk(Position position)
    {
        Tower tower = game.getTower(position);

        // Determine which Shape field corresponds to the tower
        Shape currentPole = null;
        if (position == Position.LEFT)
        {
            currentPole = left;
        }
        else if (position == Position.MIDDLE)
        {
            currentPole = middle;
        }
        else if (position == Position.RIGHT)
        {
            currentPole = right;
        }

        // Calculate the new position for the disk
        int numDisksBelow = tower.size() - 1; // Number of disks below the
                                              // current one
        int newX = currentPole.getX()
            + (currentPole.getWidth() - tower.peek().getWidth()) / 2;
        int newY = currentPole.getY() + currentPole.getHeight()
            - (numDisksBelow * (DISK_HEIGHT + DISK_GAP) + DISK_HEIGHT);

        // Move the disk to the new position
        Disk currentDisk = tower.peek();
        currentDisk.moveTo(newX, newY);
    }


    /**
     * Updates the view whenever a disk is moved in the back-end
     *
     * @param o
     *            The observable that triggered the update
     * @param arg
     *            arguments sent by the game; should be a position
     */
    @SuppressWarnings("deprecation")
    public void update(Observable o, Object arg)
    {
        if (arg.getClass() == Position.class)
        {
            Position position = (Position)arg;
            moveDisk(position);
            sleep();
        }
    }


    /**
     * Runs when the Solve button is clicked, tells the puzzle to start solving
     *
     * @param button
     *            the button that was clicked
     */
    public void clickedSolve(Button button)
    {
        button.disable();
        new Thread() {
            public void run()
            {
                game.solve();
            }
        }.start();
    }


    private void sleep()
    {
        try
        {
            Thread.sleep(500);
        }
        catch (Exception e)
        {
        }
    }

}
