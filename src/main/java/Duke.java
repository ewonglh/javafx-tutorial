/**
 * Generates responses for Duke's chat messages.
 */
public class Duke {

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
        return "Duke heard: " + input;
    }
}
