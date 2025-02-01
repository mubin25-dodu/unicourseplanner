import java.lang.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileWriter;

public class Signup extends JFrame implements ActionListener, MouseListener {
    JPanel panel, panel2;
    JLabel confirmpassword, backgroundLabel, studentid, password, welcome, coursePlanner, join, nameLabel, depLabel,
            email;
    JLabel aiub;
    JTextField student, studentname, emailtf;
    JPasswordField pass, confirmpass;
    JButton login, signup;
    ImageIcon backgroundImage;
    JComboBox combo;
    Font font1, font2, font3, font4, font5;
    Color color1, color3, color2;
    Image img;
    users us;
    login lg;

    public Signup(users us,login lg) {
        super("Sign up");
        this.setSize(700, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.lg = lg;
		this.us = us;

        color1 = new Color(8, 86, 147); // dark blue
        color2 = new Color(255, 255, 255); // white
        color3 = new Color(18, 121, 179); // button after

        font1 = new Font(null, Font.BOLD, 12);
        font2 = new Font(null, Font.BOLD, 14);
        font3 = new Font(null, Font.BOLD, 12);
        font4 = new Font(null, Font.BOLD, 14);
        font5 = new Font(null, Font.BOLD, 16); // TextButtons

        panel = new JPanel(null);
        panel.setBackground(Color.WHITE);
        panel.setBounds(300, 0, 500, 700);

        signup = new JButton("Sign up");
        signup.setBackground(color1);
        signup.setForeground(color2);
        signup.setFont(font2);
        signup.setFocusable(false);
        signup.setBounds(130, 310, 150, 30);
        signup.addMouseListener(this);
        signup.addActionListener(this);

        welcome = new JLabel("Fill up the boxes below");
        welcome.setFont(font5);
        welcome.setForeground(color1);
        welcome.setBounds(100, 20, 200, 30);

        studentid = new JLabel("Student ID:");
        studentid.setFont(font2);
        studentid.setForeground(color1);
        studentid.setBounds(50, 70, 100, 20);

        nameLabel = new JLabel("Full Name:");
        nameLabel.setFont(font2);
        nameLabel.setForeground(color1);
        nameLabel.setBounds(50, 110, 100, 20);

        studentname = new JTextField();
        // studentname.setForeground(new Color(15, 184, 224));
        studentname.setFont(font2);
        studentname.setBounds(150, 110, 200, 20);

        student = new JTextField();
        student.setFont(font2);
        // student.setForeground(new Color(15, 184, 224));
        student.setBounds(150, 70, 200, 20);

        password = new JLabel("Password:");
        password.setFont(font2);
        password.setForeground(color1);
        password.setBounds(50, 190, 100, 20);

        pass = new JPasswordField();
        pass.setFont(font2);
        pass.setBounds(150, 190, 150, 20);

        confirmpassword = new JLabel("Confirm Password:");
        confirmpassword.setFont(font2);
        confirmpassword.setForeground(color1);
        confirmpassword.setBounds(50, 230, 150, 20);

        confirmpass = new JPasswordField();
        confirmpass.setFont(font2);
        confirmpass.setBounds(200, 230, 150, 20);

        email = new JLabel("Email / Ph:");
        email.setFont(font2);
        email.setForeground(color1);
        email.setBounds(50, 150, 100, 20);
        panel.add(email);

        emailtf = new JTextField();
        emailtf.setFont(font2);
        emailtf.setBounds(150, 150, 200, 20);
        panel.add(emailtf);

        depLabel = new JLabel("Choose your department:");
        depLabel.setFont(font2);
        depLabel.setBounds(50, 270, 200, 20);
        depLabel.setForeground(color1);

        String items[] = { "CSE", "EEE" };
        combo = new JComboBox<>(items);
        combo.setBounds(240, 272, 60, 20);
        combo.setForeground(color1);
        combo.setBackground(color2);
        combo.setFocusable(false);

        panel.add(confirmpass);
        panel.add(confirmpassword);
        panel.add(combo);
        panel.add(depLabel);
        panel.add(signup);
        panel.add(student);
        panel.add(studentname);
        panel.add(studentid);
        panel.add(welcome);
        panel.add(password);
        panel.add(pass);
        panel.add(nameLabel);

        this.add(panel);
        // signup.addActionListener(this);

        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(new Color(8, 86, 147));
        panel2.setBounds(0, 0, 200, 700);

        backgroundLabel = new JLabel();
        backgroundLabel.setBounds(0, 0, 100, 100);
        backgroundImage = new ImageIcon("icons8-password.gif");
        img = backgroundImage.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        backgroundImage = new ImageIcon(img);
        backgroundLabel.setIcon(backgroundImage);
        panel2.add(backgroundLabel);

        aiub = new JLabel("AIUB");
        aiub.setFont(new Font(null, Font.BOLD, 70));
        aiub.setForeground(color2);
        aiub.setBounds(70, 70, 200, 90);

        coursePlanner = new JLabel("Course Planner");
        coursePlanner.setFont(new Font(null, Font.PLAIN, 26));
        coursePlanner.setForeground(color2);
        coursePlanner.setBounds(61, 150, 200, 30);

        join = new JLabel("Already have an account!");
        join.setFont(font2);
        join.setForeground(color2);
        join.setBounds(70, 200, 200, 100);

        login = new JButton("Log in");
        login.setBounds(80, 310, 150, 30);
        login.setFont(font2);
        login.setBackground(color2);
        login.setForeground(color1);
        login.setFocusable(false);
        login.addMouseListener(this);
        login.addActionListener(this);
        //     public void actionPerformed(ActionEvent e) {
        //         login l = new login();
        //         l.setVisible(true);
        //         l.setLocationRelativeTo(null);
        //         dispose();
        //     }
        // });
        panel2.add(login);
        panel2.add(join);
        panel2.add(aiub);
        panel2.add(coursePlanner);

        this.add(panel2);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == signup) {
            signup.setBackground(color2);
            signup.setForeground(color1);
        } else if (e.getSource() == login) {
            login.setBackground(color1);
            login.setForeground(color2);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

        if (e.getSource() == signup) {
            signup.setBackground(color1);
            signup.setForeground(color2);
        } else if (e.getSource() == login) {
            login.setBackground(color2);
            login.setForeground(color1);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

    //JTextField student, studentname, emailtf;
    // JPasswordField pass, confirmpass;
   
        if (signup.getText().equals(command)) {
            String n = studentname.getText();
            String i = student.getText();
            String c = emailtf.getText();
            String p = pass.getText();
            String cp = confirmpass.getText();
            String d = combo.getSelectedItem().toString();
            String pa;

            if (!p.isEmpty() && !cp.isEmpty() && p.equals(cp)) {
                pa = cp;
                user u = new user(n, i, pa, c, d);

                int index = us.userExistsignup(c);
                if (index != -1) {
                     JOptionPane.showMessageDialog(this, "User already Exists! login to continue");} 
             
                   else if (!i.isEmpty() && !n.isEmpty() && !c.isEmpty() && !d.isEmpty()) {
                        us.adduser(u);
                        JOptionPane.showMessageDialog(this, "Sign up successful! Please login to continue");

                      

                        // String data = emailtf.getText() + "\n";
                        // data += combo.getSelectedItem().toString() + "\n";
                       
                        

                        try {
                            String filename = "Files/" + emailtf.getText() + ".txt"; // Using user mail or phone number for the filename
                            FileWriter F = new FileWriter(filename, true);
                            // F.write(data);
                            F.close(); 
                            
                            // Clearing fields after successful signup
                         student.setText("");
                        pass.setText("");
                        studentname.setText("");
                        confirmpass.setText("");
                        emailtf.setText("");
                        } catch (Exception a) {
                            a.printStackTrace();
                        }
                    }else if(i.isEmpty() && n.isEmpty()&& p.isEmpty() && c.isEmpty() && d.isEmpty() ){
                    JOptionPane.showMessageDialog(this, "Information missing.");
                 }
            } else {
                JOptionPane.showMessageDialog(this, "Passwords do not match.");
            }
        } 
        else if (login.getText().equals(command)) {
             login l =  new login(us);
            l.setVisible(true);
            this.setVisible(false);
        }
    }
}
