import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;

import javax.swing.*;

public class adminsignup extends JFrame implements ActionListener {
    private JPanel loginp;
    private JLabel adminid, password, email,pascword,nameLabel,depLabel;
    private JTextField usertf, username, id,mail;
    private JPasswordField pass,pasc ;
    private JButton exit, add;
    private Font font1, font2;
    private Color color1, color2;
	private JComboBox com;
    private depdatas de;
    private depdata dp;
    private adminlogin al;
    private users us;
    private login lg;

    public adminsignup(users us, login lg) {
        super("Add Admin");
        this.setSize(500, 270);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

    
		this.us = us;
        this.lg = lg;

        color1 = new Color(8, 86, 147); // dark blue
        color2 = new Color(255, 255, 255); // white

        font1 = new Font(null, Font.BOLD, 16); // text
        font2 = new Font(null, Font.BOLD, 12); // button

        loginp = new JPanel();
        loginp.setLayout(null);
        loginp.setBackground(color2);
        loginp.setBounds(300, 0, 500, 700);

        nameLabel = new JLabel("Full Name:");
        nameLabel.setFont(font2);
        nameLabel.setForeground(color1);
        nameLabel.setBounds(10, 50, 80, 20);
        
		loginp.add(nameLabel);

        username = new JTextField();
        // username.setForeground(new Color(15, 184, 224));
        username.setFont(font2);
        username.setBounds(90, 50, 120, 20);
 
        loginp.add(username);
        
        adminid = new JLabel("Admin/User ID:");
        adminid.setForeground(color1);
        adminid.setFont(font2);
        adminid.setBounds(250, 50, 100, 20);
		
		loginp.add(adminid);
		
		id = new JTextField();
        id.setBounds(350, 50, 120, 20); 
		
		loginp.add(id);

        password = new JLabel("Password:");
        password.setForeground(color1);
        password.setFont(font2);
        password.setBounds(10, 85, 120, 20);
		
		loginp.add(password);

        pass = new JPasswordField();
        pass.setBounds(90, 85, 120, 20);
		
		loginp.add(pass);

        pascword = new JLabel("Confirm Password:");
        pascword.setFont(font2);
        pascword.setForeground(color1);
        pascword.setBounds(230, 85, 120, 20);
		
		loginp.add(pascword);

        pasc = new JPasswordField();
        pasc.setFont(font2);
        pasc.setBounds(350, 85, 120, 20);
		
		loginp.add(pasc);

        email = new JLabel("Email / Ph:");
        email.setFont(font2);
        email.setForeground(color1);
        email.setBounds(10, 120, 100, 20);
        loginp.add(email);

        mail = new JTextField();
        mail.setFont(font2);
        mail.setBounds(90, 120, 200, 20);
        loginp.add(mail);
		
		depLabel = new JLabel("Choose your department:");
        depLabel.setFont(font2);
        depLabel.setBounds(10, 155, 200, 20);
        depLabel.setForeground(color1);

        String items[] = { "Admin","CSE" };
        com = new JComboBox<>(items);
        com.setBounds(170, 155, 60, 20);
        com.setForeground(color1);
        com.setBackground(color2);
        com.setFocusable(false);
		
		loginp.add(com);
        loginp.add(depLabel);


        exit = new JButton("close");
        exit.setBounds(10, 200, 90, 27);
        exit.setFont(font2);
        exit.setBackground(color1);
        exit.setForeground(color2);
        exit.setFocusable(false);
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adminpanel a = new adminpanel(al, de);
                a.setVisible(true);
                dispose();
            }
        });
		
		loginp.add(exit);
 
        add = new JButton();
        add = new JButton("Add ");
        add.setFont(font1);
        add.setBackground(color1);
        add.setForeground(color2);
        add.setBounds(385, 200, 90, 27);
        add.setBorderPainted(false);
        add.setFocusPainted(false);
        add.addActionListener(this);
        loginp.add(add);
		 
		 
		
       
        this.add(loginp);

    }

    
        public static void main(String[] args) {
            users us = new users(); 
            login lg = new login(us); 
            
              adminsignup adminSignup = new adminsignup(us, lg);
            adminSignup.setVisible(true);
        }
    

    @Override
    public void actionPerformed(ActionEvent e) {
          String command = e.getActionCommand();
//  JTextField usertf, username, id,mail;
//     JPasswordField pass,pasc ;
   
        if (add.getText().equals(command)) {
            String un= username.getText();
            String di= id.getText();
            String mai= mail.getText();
            String passs= pass.getText();
            String cpass= pasc.getText();
            String comp= com.getSelectedItem().toString();
            String pant;

            if (!passs.isEmpty() && !cpass.isEmpty() && passs.equals(cpass)) {
                pant = cpass;
                user u = new user(un, di, mai, pant,comp);
                
             
                    if (!di.isEmpty() && !un.isEmpty() && !cpass.isEmpty() && !comp.isEmpty()) {
                        us.adduser(u);
                        JOptionPane.showMessageDialog(this, "Sign up successful! Please login to continue");

                      

                        // String data = username.getText() + "\n";
                        // data += id.getText() + "\n";
                        // data += mail.getText() + "\n";
                        // data += pass.getText() + "\n";
                        // data += pasc.getText() + "\n";
                        // data += com.getSelectedItem().toString() + "\n";

                        // try {
                        //     String filename = "Files/" + mail.getText() + ".txt"; // Using user mail or phone number for the filename
                        //     FileWriter F = new FileWriter(filename, true);
                        //     F.write(data);
                        //     F.close(); 
                            
                        //     // Clearing fields after successful signup
                        //  id.setText("");
                        // pass.setText("");
                        // username.setText("");
                        // pasc.setText("");
                        // mail.setText("");
                        // } catch (Exception a) {
                        //     a.printStackTrace();
                        // }
                    }else if(di.isEmpty() && un.isEmpty()&& passs.isEmpty() && cpass.isEmpty() && comp.isEmpty() ){
                    JOptionPane.showMessageDialog(this, "Information missing.");
                 }
            } else {
                JOptionPane.showMessageDialog(this, "Passwords do not match.");
            }
    }
}
}