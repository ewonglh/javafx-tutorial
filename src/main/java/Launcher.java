import javafx.application.Application;

/**
 * A launcher class to work around JavaFX classpath issues.
 */
public class Launcher {

    /**
     * Launches the JavaFX application.
     *
     * @param arguments command-line arguments passed to the application.
     */
    public static void main(String[] arguments) {
        Application.launch(Main.class, arguments);
    }
}
