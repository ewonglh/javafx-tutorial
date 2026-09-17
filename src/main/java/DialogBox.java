import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * Represents a chat dialog containing a message and a speaker image.
 */
public class DialogBox extends HBox {

    private final Label text;
    private final ImageView displayPicture;

    /**
     * Creates a dialog box with the given message and speaker image.
     *
     * @param message the message to display.
     * @param image the image representing the speaker.
     */
    public DialogBox(String message, Image image) {
        text = new Label(message);
        displayPicture = new ImageView(image);

        text.setWrapText(true);
        displayPicture.setFitWidth(100.0);
        displayPicture.setFitHeight(100.0);
        setAlignment(Pos.TOP_RIGHT);

        getChildren().addAll(text, displayPicture);
    }
}
