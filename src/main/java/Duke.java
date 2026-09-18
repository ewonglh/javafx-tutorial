/**
 * Generates responses for Duke's chat messages.
 */
public class Duke {

    private String commandType;

    /**
     * Starts Duke's console entry point.
     *
     * @param arguments command-line arguments supplied by the user.
     */
    public static void main(String[] arguments) {
        System.out.println("Hello!");
    }

    /**
     * Generates a response that echoes the user's message.
     *
     * @param input the user's chat message.
     * @return Duke's response to the message.
     */
    public String getResponse(String input) {
        commandType = determineCommandType(input);
        return "Duke heard: " + input;
    }

    /**
     * Identifies the command category used for styling Duke's response.
     *
     * @param input the user's chat message.
     * @return the style category associated with the message, or an empty string.
     */
    private String determineCommandType(String input) {
        String trimmedInput = input.trim();
        if (trimmedInput.isEmpty()) {
            return "";
        }

        String command = trimmedInput.split("\\s+", 2)[0];
        return switch (command) {
        case "todo", "deadline", "event" -> "AddCommand";
        case "mark", "unmark" -> "ChangeMarkCommand";
        case "delete" -> "DeleteCommand";
        default -> "";
        };
    }

    /**
     * Returns the command category from the most recently processed message.
     *
     * @return the most recently identified command category.
     */
    public String getCommandType() {
        return commandType;
    }
}
