package ip.command;

import java.util.LinkedList;
import java.util.Scanner;

import ip.task.Task;
import ip.utility.TaskList;

/**
 * DukeCommand to find tasks matching specified keyword.
 */
public class FindCommand extends DukeCommand {
    /** Options following the find command */
    private final Scanner options;
    private final LinkedList<Task> results = new LinkedList<>();
    private String keyword = "";

    public FindCommand(Scanner options) {
        this.options = options;
    }

    /**
     * Finds tasks with descriptions matching given keyword.
     *
     * @param taskList List to search.
     */
    @Override
    public String execute(TaskList taskList) {
        if (options.hasNext()) {
            keyword = options.nextLine().trim();
        }
        for (Task task : taskList.tasks) {
            if (task.hasString(keyword)) {
                results.add(task);
            }
        }
        if (results.isEmpty()) {
            return "No tasks with keyword \"" + keyword + "\" found.";
        }
        StringBuilder stringResults = new StringBuilder();
        stringResults.append("Results from search keyword \"").append(keyword).append("\": \n");
        for (Task task : results) {
            stringResults.append(task);
            stringResults.append('\n');
        }
        return stringResults.toString();
    }
}
