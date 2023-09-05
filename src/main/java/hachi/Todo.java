package hachi;

public class Todo extends Task {

    public Todo(String taskName) {
        super(taskName);
    }

    /**
     * Converts Todo object to its string representation when stored in the hard drive.
     *
     * @return String representation when stored in text file on user's hard drive
     */
    @Override
    public String toData() {
        return "T" + " | " + super.toData();
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
