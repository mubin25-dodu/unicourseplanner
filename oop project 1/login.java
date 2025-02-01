import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class login extends JFrame implements ActionListener, MouseListener {
    JPanel panel, panel2;
    JLabel studentid, backgroundLabel, password, welcome, aiub, coursePlanner, join, join2;
    JLabel background;
    JTextField student;
    JPasswordField pass;
    JButton login, back, signup, adminpanel, forget;
    ImageIcon icon;
    Font font1, font2, font3, font4, font5;
    Color color1, color2, color3;
    ImageIcon backgroundImage, img;
    Image tempimg, bg;
    users us;
    login lg;
    user u;

    public login(users us) {
        super("Log in");
        icon = new ImageIcon("aiubpnglogo.png");
        this.setSize(700, 500);
        this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.us=new users();

        // backgroundImage = new ImageIcon("IMG_7611.jpg");
        // backgroundLabel = new JLabel(backgroundImage);
        // bg = backgroundImage.getImage();
        // tempimg = bg.getScaledInstance(700, 500, Image.SCALE_SMOOTH);
        // backgroundImage = new ImageIcon(tempimg);
        // backgroundLabel.setIcon(backgroundImage);
        // backgroundLabel.setBounds(0, 0, 700, 500);

        color1 = new Color(8, 86, 147); // dark blue
        color2 = new Color(255, 255, 255); // white
        color3 = new Color(18, 121, 179); // button after

        font1 = new Font(null, Font.BOLD, 12);
        font2 = new Font(null, Font.BOLD, 14);
        font3 = new Font(null, Font.BOLD, 12);
        font4 = new Font(null, Font.BOLD, 14);
        font5 = new Font(null, Font.BOLD, 16);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(color1);
        panel.setBounds(300, 0, 500, 700);

        welcome = new JLabel("Welcome!");
        welcome.setFont(new Font(null, Font.BOLD, 36));
        welcome.setForeground(color2);
        welcome.setBounds(110, 50, 250, 70);

        studentid = new JLabel("Student ID:");
        studentid.setForeground(color2);
        studentid.setFont(font2);
        studentid.setBounds(50, 150, 100, 20);

        password = new JLabel("Password:");
        password.setForeground(color2);
        password.setFont(font2);
        password.setBounds(51, 196, 100, 20);

        pass = new JPasswordField();
        pass.setBounds(150, 200, 200, 20);

        student = new JTextField();
        student.setBounds(150, 150, 200, 20);

        login = new JButton("Log in");
        login.setFocusable(false);
        login.setBackground(color2);
        login.setForeground(color1);
        login.setBounds(100, 250, 100, 30);
        login.addMouseListener(this);

        forget = new JButton("Forgot password ?");
        forget.setBorderPainted(false);
        forget.setFocusPainted(false);
        forget.setContentAreaFilled(false);
        forget.setFont(font1);
        forget.setForeground(color2);
        forget.setBackground(new Color(8, 86, 147));
        forget.setFont(font2);
        forget.setBounds(120, 286, 200, 20);
        panel.add(forget);
        forget.addMouseListener(this);
        forget.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                forget l = new forget(us, lg);
                l.setVisible(true);
                l.setLocationRelativeTo(null);
                dispose();
            }
        });

        adminpanel = new JButton("Admin!");
        adminpanel.setFocusable(false);
        adminpanel.setForeground(color1);
        adminpanel.setFont(font2);
        adminpanel.setBackground(color2);
        adminpanel.addMouseListener(this);
        adminpanel.setBounds(220, 250, 110, 30);

        adminpanel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adminlogin a = new adminlogin();
                a.setVisible(true);
                a.setLocationRelativeTo(null);
                dispose();
            }
        });

        panel.add(adminpanel);
        panel.add(login);
        panel.add(student);
        panel.add(pass);
        panel.add(password);
        panel.add(studentid);
        panel.add(welcome);

        this.add(panel);

        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(color2);
        panel2.setBounds(0, 0, 200, 700);

        // img = new ImageIcon("new_campus_pic_4.png");
        // background = new JLabel(img);
        // background.setBounds(10, 10, 100, 200);
        // panel2.add(background);

        aiub = new JLabel("AIUB");
        aiub.setFont(new Font(null, Font.BOLD, 70));
        aiub.setForeground(color1);
        aiub.setBounds(70, 70, 200, 90);

        coursePlanner = new JLabel("Course Planner");
        coursePlanner.setFont(new Font(null, Font.BOLD, 26));
        coursePlanner.setForeground(color1);
        coursePlanner.setBounds(61, 150, 200, 30);

        // img1= new ImageIcon("OIG-removebg-preview.png");
        // img = new JLabel(img1);
        // img.setBounds(80, 250, 150, 130);
        // panel2.add(img);

        join = new JLabel("Don't have an account!!");
        join.setFont(font2);
        join.setForeground(color1);
        join.setBounds(76, 150, 200, 100);

        join2 = new JLabel("Join us");
        join2.setFont(new Font(null, Font.BOLD, 16));
        join2.setForeground(color1);
        join2.setBounds(130, 170, 200, 100);

        signup = new JButton("Sign up");
        signup.setBounds(80, 250, 150, 30);
        signup.setFocusable(false);
        signup.setBackground(color1);
        signup.setForeground(color2);
        signup.addMouseListener(this);
        signup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Signup registrationPage = new Signup(us,lg);
                registrationPage.setVisible(true);
                registrationPage.setLocationRelativeTo(null);
                dispose();
            }
        });

        panel2.add(join2);
        panel2.add(join);
        panel2.add(aiub);
        panel2.add(coursePlanner);
        panel2.add(signup);

        this.add(panel2);

        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                String command = ae.getActionCommand();
             
                   // JTextField student;
                   // JPasswordField pass;

                if (login.getText().equals(command)) {
                String d = student.getText();
                String a =pass.getText();

                int index = us.userExists(d);
                if(index!=-1){
                    u = us.getuser(index, a);
                    if( u!= null){
                        // JOptionPane.showMessageDialog(null, "Login successfull!");

                     home h = new home(u,us,lg);
                    h.setVisible(true);
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Password incorrect!" );
                }
                  
                } else {

                    JOptionPane.showMessageDialog(null, "Invalid Student ID or Password", "Login Failed",
                            JOptionPane.ERROR_MESSAGE);

                    student.setText("");
                    pass.setText("");
                }
            }
        }
        });

    }

    // public static void main(String[] args) {
    //     users us = new users();
    //     login l = new login(us);
    //     l.setVisible(true);
    //     l.setLocationRelativeTo(null);
    // }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == login) {
            login.setBackground(color1);
            login.setForeground(color2);
        } else if (e.getSource() == signup) {
            signup.setBackground(color2);
            signup.setForeground(color1);
        } else if (e.getSource() == adminpanel) {
            adminpanel.setBackground(color1);
            adminpanel.setForeground(color2);
        } else if (e.getSource() == forget) {
            forget.setFont(font5);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == login) {
            login.setBackground(color2);
            login.setForeground(color1);
        } else if (e.getSource() == signup) {
            signup.setBackground(color1);
            signup.setForeground(color2);
        } else if (e.getSource() == adminpanel) {
            adminpanel.setBackground(color2);
            adminpanel.setForeground(color1);
        } else if (e.getSource() == forget) {
            forget.setFont(font1);
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
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    }
}