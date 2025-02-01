import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class forget extends JFrame implements ActionListener, MouseListener {
    JPanel panel, panel2;
    JLabel join, studentid, confirmpassword, password, welcome, coursePlanner, nameLabel, depLabel, email;
    JLabel aiub;
    JTextField student, studentname, emailtf;
    JPasswordField confirmpass, pass;
    JButton login, signup, confirm;
    JComboBox combo;
    Font font1, font2, font3, font4, font5;
    Color color1, color2, color3;
    users us;
    user u;
    login lg;

    public forget(users us, login lg ) {
        super("Forget password ");
        this.setSize(700, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.lg = lg;
		this.us = us;

        panel = new JPanel(null);
        panel.setBackground(Color.WHITE);
        panel.setBounds(300, 0, 500, 700);

        color1 = new Color(8, 86, 147); // dark blue
        color2 = new Color(255, 255, 255); // white
        color3 = new Color(18, 121, 179); // button after

        font1 = new Font(null, Font.BOLD, 12);
        font2 = new Font(null, Font.BOLD, 14);
        font3 = new Font(null, Font.BOLD, 12);
        font4 = new Font(null, Font.BOLD, 14);
        font5 = new Font(null, Font.BOLD, 16);

        panel = new JPanel(null);
        panel.setBackground(Color.WHITE);
        panel.setBounds(300, 0, 500, 700);

        confirm = new JButton("Confirm");
        confirm.setBackground(color1);
        confirm.setForeground(color2);
        confirm.setFont(font2);
        confirm.setFocusable(false);
        confirm.setBounds(130, 310, 150, 30);
        confirm.addMouseListener(this);
        confirm.addActionListener(this);

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

        password = new JLabel("New Password:");
        password.setFont(font2);
        password.setForeground(color1);
        password.setBounds(50, 190, 150, 20);

        pass = new JPasswordField();
        pass.setFont(font2);
        pass.setBounds(200, 190, 150, 20);

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

        String items[] = { "CSE" };
        combo = new JComboBox<>(items);
        combo.setBounds(240, 272, 60, 20);
        combo.setForeground(color1);
        combo.setBackground(color2);
        combo.setFocusable(false);

        panel.add(confirmpass);
        panel.add(confirmpassword);
        panel.add(combo);
        panel.add(depLabel);
        panel.add(confirm);
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

        aiub = new JLabel("AIUB");
        aiub.setFont(new Font(null, Font.PLAIN, 70));
        aiub.setForeground(Color.WHITE);
        aiub.setBounds(70, 70, 200, 90);

        coursePlanner = new JLabel("Course Planner");
        coursePlanner.setFont(new Font(null, Font.PLAIN, 26));
        coursePlanner.setForeground(Color.WHITE);
        coursePlanner.setBounds(61, 150, 200, 30);

        signup = new JButton("Sign up");
        signup.setBounds(80, 250, 150, 30);
        signup.setFocusable(false);
        signup.setBackground(color2);
        signup.setForeground(color1);
        signup.addMouseListener(this);
        signup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Signup registrationPage = new Signup(us,lg);
                registrationPage.setVisible(true);
                registrationPage.setLocationRelativeTo(null);
                dispose();
            }
        });
        panel2.add(signup);

        join = new JLabel("Or Else You Can");
        join.setFont(font4);
        join.setForeground(color2);
        join.setBounds(90, 180, 200, 100);
        panel2.add(join);

        login = new JButton("Log in");
        login.setBounds(80, 310, 150, 30);
        login.setBackground(Color.white);
        login.setForeground(color1);
        login.setFocusable(false);
        login.addMouseListener(this);
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login l = new login(us);
                l.setVisible(true);
                l.setLocationRelativeTo(null);
                dispose();
            }
        });

        panel2.add(login);
        // panel2.add(join);
        panel2.add(aiub);
        panel2.add(coursePlanner);

        this.add(panel2);
    }

    // public static void main(String[] args) {
    //      users us= new users();
    //      login lg= new login(us);
    //     forget l = new forget(us, lg);
    //     l.setVisible(true);
    //     l.setLocationRelativeTo(null);
    // }

   // Inside the actionPerformed method
   @Override
   public void actionPerformed(ActionEvent e) {
       String command = e.getActionCommand();
       if (confirm.getText().equals(command)) {
           String n = studentname.getText();
           String i = student.getText();
           String c = emailtf.getText();
           String p = pass.getText();
           String cp = confirmpass.getText();
           String d = combo.getSelectedItem().toString();
           String pa;
   
           int index = us.userExists(c);
           if (index != -1) {
               if (!p.isEmpty() && !cp.isEmpty() && p.equals(cp)) {
                   pa = cp;
                   us.updatePassword(n, i, c, d, pa); // Change the password for the user
                   JOptionPane.showMessageDialog(this, "Password updated. Please login to continue.");
               } else {
                   JOptionPane.showMessageDialog(this, "Password mismatch!");
               }
           } else {
               JOptionPane.showMessageDialog(this, "User not found!");
           }
       }
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
        if (e.getSource() == login) {
            login.setBackground(color1);
            login.setForeground(color2);
        } else if (e.getSource() == signup) {
            signup.setBackground(color1);
            signup.setForeground(color2);
        } else if (e.getSource() == confirm) {
            confirm.setBackground(color2);
            confirm.setForeground(color1);
            // } else if (e.getSource() == forget) {
            // forget.setFont(font5);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == login) {
            login.setBackground(color2);
            login.setForeground(color1);
        } else if (e.getSource() == signup) {
            signup.setBackground(color2);
            signup.setForeground(color1);
        } else if (e.getSource() == confirm) {
            confirm.setBackground(color1);
            confirm.setForeground(color2);
        }
    }

}