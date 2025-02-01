package hudai;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

public class ShoppingCart extends JFrame implements ActionListener {
    DefaultListModel<String> productList = new DefaultListModel<>();
    JList<String> availableProducts;
    JButton addButton, checkoutButton;
    JTextArea cartArea;

    public ShoppingCart() {
        setTitle("Shopping Cart");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(1, 3));

        availableProducts = new JList<>(productList);
        availableProducts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        panel.add(new JScrollPane(availableProducts));

        addButton = new JButton("Add to Cart");
        addButton.addActionListener(this);
        panel.add(addButton);

        cartArea = new JTextArea();
        panel.add(new JScrollPane(cartArea));

        add(panel, BorderLayout.CENTER);

        checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(this);
        add(checkoutButton, BorderLayout.SOUTH);

        populateProductList(); // Add some sample products
    }

    // Method to populate product list
    private void populateProductList() { try {
          File f = new File ("Files/userdata=money.txt");
          Scanner sc = new Scanner(f);

        while (sc.hasNext() ) {
            String l1 = sc.nextLine();
            String Name = l1.substring(5);
            System.out.println(Name);
         productList.addElement(Name);     
          
        }
        sc.close();
          
        } catch (Exception e) {
           System.out.println("file nai vai nai");
           return;
        }

        
       

    }

    // Action performed when buttons are clicked
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String selectedProduct = availableProducts.getSelectedValue();
            if (selectedProduct != null) {
                cartArea.append(selectedProduct + "\n");
            } else {
                JOptionPane.showMessageDialog(this, "Please select a product to add to cart.");
            }
        } else if (e.getSource() == checkoutButton) {
            String cartContent = cartArea.getText();
            if (!cartContent.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Checkout completed!\nItems in cart:\n" + cartContent);
                cartArea.setText(""); // Clear the cart after checkout
            } else {
                JOptionPane.showMessageDialog(this, "Your cart is empty.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ShoppingCart shoppingCart = new ShoppingCart();
            shoppingCart.setVisible(true);
        });
    }
}
