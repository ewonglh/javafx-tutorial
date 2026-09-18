import java.io.IOException;
import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * Represents a chat dialog containing a message and a speaker image.
 */
public class DialogBox extends HBox {

    @FXML
    private Label dialog;
    @FXML
    private ImageView displayPicture;

    /**
     * Creates a dialog box with the given message and speaker image.
     *
     * @param message the message to display.
     * @param image the image representing the speaker.
     */
    private DialogBox(String message, Image image) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource("/view/DialogBox.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new IllegalStateException("Unable to load a dialog box.", exception);
        }

        dialog.setText(message);
        displayPicture.setImage(image);
    }

    /**
     * Flips the dialog so the speaker image is on the left and text is on the right.
     */
    private void flip() {
        ObservableList<Node> children = FXCollections.observableArrayList(getChildren());
        Collections.reverse(children);
        getChildren().setAll(children);
        setAlignment(Pos.TOP_LEFT);
        dialog.getStyleClass().add("reply-label");
    }

    /**
     * Creates a dialog box representing a user's message.
     *
     * @param message the message to display.
     * @param image the image representing the user.
     * @return a right-aligned user dialog box.
     */
    public static DialogBox getUserDialog(String message, Image image) {
        return new DialogBox(message, image);
    }

    /**
     * Creates a dialog box representing Duke's response.
     *
     * @param message the response to display.
     * @param image the image representing Duke.
     * @return a left-aligned Duke dialog box.
     */
    public static DialogBox getDukeDialog(String message, Image image) {
        return getDukeDialog(message, image, "");
    }

    /**
     * Creates a styled dialog box representing Duke's response.
     *
     * @param message the response to display.
     * @param image the image representing Duke.
     * @param commandType the command category used to style the response.
     * @return a left-aligned and command-styled Duke dialog box.
     */
    public static DialogBox getDukeDialog(String message, Image image, String commandType) {
        DialogBox dialogBox = new DialogBox(message, image);
        dialogBox.flip();
        dialogBox.changeDialogStyle(commandType);
        return dialogBox;
    }

    /**
     * Applies a command-specific style to Duke's response bubble.
     *
     * @param commandType the command category used to choose the style.
     */
    private void changeDialogStyle(String commandType) {
        switch (commandType) {
        case "AddCommand" -> dialog.getStyleClass().add("add-label");
        case "ChangeMarkCommand" -> dialog.getStyleClass().add("marked-label");
        case "DeleteCommand" -> dialog.getStyleClass().add("delete-label");
        default -> {
            // Keep the default response style.
        }
        }
    }
}
