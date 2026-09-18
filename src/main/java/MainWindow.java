import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * Controls Duke's main FXML-based chat window.
 */
public class MainWindow extends AnchorPane {

    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Duke duke;

    private final Image userImage = new Image(
            this.getClass().getResourceAsStream("/images/DaUser.png"));
    private final Image dukeImage = new Image(
            this.getClass().getResourceAsStream("/images/DaDuke.png"));

    /**
     * Initializes the scroll position of the chat window.
     */
    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    /**
     * Injects the Duke response engine into this controller.
     *
     * @param duke the response engine used to answer messages.
     */
    public void setDuke(Duke duke) {
        this.duke = duke;
    }

    /**
     * Adds the user's message and Duke's response to the dialog container.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = duke.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getDukeDialog(response, dukeImage));
        userInput.clear();
    }
}
