import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class uni {
    public static void main(String[] args) {
        openURL("https://www.aiub.edu/");
    }

    public static void openURL(String url) {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            try {
                Desktop.getDesktop().browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Desktop browsing not supported, cannot open URL.");
        }
    }
}