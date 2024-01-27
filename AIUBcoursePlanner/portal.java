
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.net.URL;

public class portal extends JFrame {
    private JPanel jfxPanel;

    public void WebPageViewer() {
        initComponents();
    }

    private void initComponents() {
        jfxPanel = new JPanel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Web Page Viewer");
        setSize(800, 600);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Platform.exit();
                System.exit(0);
            }
        });

        add(jfxPanel);

        Platform.runLater(this::initFX);
    }

    private void initFX() {
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();

        jfxPanel.setScene(new Scene(webView));

        // Replace the URL below with the desired website URL
        try {
            URL url = new URL("https://www.example.com");
            webEngine.load(url.toExternalForm());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WebPageViewer webPageViewer = new WebPageViewer();
            webPageViewer.setVisible(true);
        });
    }
}
