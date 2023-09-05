package hachi;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Handles all interaction with the user on the UI front.
 */
public class Ui {

    private static String name = "Hachi";

    private final Scanner in;

    private final PrintStream out;

    /**
     * Overridden constructor that uses the default input and output from the system.
     */
    public Ui() {
        this(System.in, System.out);
    }

    /**
     * Overridden constructor that initialises the input and output.
     * @param in Input of UI.
     * @param out Output of UI.
     */
    public Ui(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
    }

    /**
     * Returns true of the user raw input line should be ignored.
     * Input should be ignored if it is a comment, is whitespace or is empty.
     *
     * @param rawInputLine the raw user input line.
     * @return true if the user raw input line should be ignored.
     */
    private boolean shouldIgnore(String rawInputLine) {
        return rawInputLine.trim().isEmpty() || isCommentLine(rawInputLine);
    }

    /**
     * Returns true if the raw user input line is a comment.
     *
     * @param rawInputLine the raw user input line.
     * @return true if the raw user input line is a comment.
     */
    private boolean isCommentLine(String rawInputLine) {
        return rawInputLine.trim().matches("#.*");
    }

    /**
     * Returns the next command typed by the user.
     *
     * @return the next non-ignored command typed by the user
     */
    public String getInput() {
        String input = in.nextLine();

        // do not take into account ignored lines
        while (shouldIgnore(input)) {
            input = in.nextLine();
        }
        return input;
    }

    /**
     * Prints out the welcome message.
     */
    public void showWelcome() {
        showLine();
        out.println("What's good my bro! People round these parts call me " + name
                + ".\nWhat can I do for ya sonny?");
        showLine();
    }

    /**
     * Prints out the error message of the exception.
     */
    public void showError(Exception e) {
        System.out.println(e.getMessage());
    }

    /**
     * Shows a message in the UI along with decorative lines.
     * @param msg The message to be shown in the UI.
     */
    public void showMessage(String msg) {
        showLine();
        out.println(msg);
        showLine();
    }


    /**
     * Prints out the UI line element.
     */
    public static void showLine() {
        System.out.println("____________________________________________________________");
    }
}