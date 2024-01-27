import javax.swing.*;
import java.awt.*;

public final class Message extends JFrame {
    public Message() {
        super("Thankyou");
        this.setSize(500, 550); // Set the frame size to accommodate the image
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        final String imagePath = "Images/dev_tester_dev_vs_test_2.jpg";
        ImageIcon imageIcon = new ImageIcon(imagePath);

        final JLabel imageLabel = new JLabel(imageIcon);
        add(imageLabel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Message();
    }
}
