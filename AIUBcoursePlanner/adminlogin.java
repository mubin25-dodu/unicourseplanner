import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class adminlogin extends JFrame implements ActionListener, MouseListener {
    private JPanel panel, panel2;
    private JLabel studentid, password, welcome, aiub, coursePlanner, join, join2;
    private JLabel img;
    private JTextField student;
    private JPasswordField pass;
    private JButton login, signup, back;
    private ImageIcon img1;
    private Font font1, font2, font3, font4;
    private Color color1, color2;
    private depdatas de;
    private depdata d;
    private adminlogin al;
    private users us;
    private login lg;
    private user u;
   
    public adminlogin() {
        super("Admin Log in");
        this.setSize(700, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.us=new users();

        color1 = new Color(8, 86, 147); // dark blue
        color2 = new Color(255, 255, 255); // white
        font1 = new Font(null, Font.BOLD, 12);
        font2 = new Font(null, Font.BOLD, 14);
        font3 = new Font(null, Font.BOLD, 12);
        font4 = new Font(null, Font.BOLD, 14);

        /*
         * color1 = new Color(8,86,147);
         * color2 = new Color(white);
         * myfont = new Font(null, Font.PLAIN, 36);
         */

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(8, 86, 147));
        panel.setBounds(300, 0, 500, 700);

        welcome = new JLabel("Welcome!");
        welcome.setFont(new Font(null, Font.BOLD, 36));
        welcome.setForeground(Color.WHITE);
        welcome.setBounds(110, 50, 250, 70);

        studentid = new JLabel("ID:");
        studentid.setForeground(Color.WHITE);
        studentid.setFont(font2);
        studentid.setBounds(103, 150, 100, 20);

        password = new JLabel("Password:");
        password.setForeground(Color.WHITE);
        password.setFont(font2);
        password.setBounds(51, 196, 100, 20);

        pass = new JPasswordField();
        pass.setBounds(150, 200, 200, 20);

        student = new JTextField();
        student.setBounds(150, 150, 200, 20);

        login = new JButton("Log in as an admin");
        login.setFocusable(false);
        login.setBackground(Color.white);
        login.setForeground(new Color(8, 86, 147));
        login.setFont(font3);
        login.setBounds(150, 250, 150, 30);
        login.addMouseListener(this);

        panel.add(login);
        panel.add(student);
        panel.add(pass);
        panel.add(password);
        panel.add(studentid);
        panel.add(welcome);

        this.add(panel);

        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(Color.white);
        panel2.setBounds(0, 0, 200, 700);

        aiub = new JLabel("AIUB");
        aiub.setFont(new Font(null, Font.BOLD, 70));
        aiub.setForeground(new Color(8, 86, 147));
        aiub.setBounds(70, 70, 200, 90);

        coursePlanner = new JLabel("Course Planner");
        coursePlanner.setFont(new Font(null, Font.BOLD, 26));
        coursePlanner.setForeground(new Color(8, 86, 147));
        coursePlanner.setBounds(61, 150, 200, 30);

        // back =new JButton("Go Back");
        // back.setBackground(color2);
        // back.setForeground(color1);
        // back.setBorderPainted(false);
        // back.setFocusPainted(false);
        // back.setBounds(4,5,100,50);
        // back.setFont(font1);
        // panel2.add(back);
        // back.addActionListener(new ActionListener() {
        // public void actionPerformed(ActionEvent e) {
        // login a = new login();
        // a.setVisible(true);
        // dispose();
        // a.setLocationRelativeTo(null);
        // }
        // });
        // img1= new ImageIcon("OIG-removebg-preview.png");
        // img = new JLabel(img1);
        // img.setBounds(80, 250, 150, 130);
        // panel2.add(img);

        join = new JLabel("NOT AN ADMIN !!");
        join.setFont(font2);
        join.setForeground(new Color(8, 86, 147));
        join.setBounds(90, 150, 200, 100);

        join2 = new JLabel("BACK TO HOME");
        join2.setFont(font2);
        join2.setForeground(new Color(8, 86, 147));
        join2.setBounds(760, 150, 200, 100);

        signup = new JButton("Log in");
        signup.setBounds(80, 250, 150, 30);
        signup.setFocusable(false);
        signup.setFont(font3);
        signup.setBackground(new Color(8, 86, 147));
        signup.setForeground(Color.white);
        signup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login registrationPage = new login(us);
                registrationPage.setVisible(true);
                dispose();
                registrationPage.setLocationRelativeTo(null);
            }
        });


        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        table.setBounds(100,100,300,300);
        table.setBackground(color1);
        panel2.add(table);
        JScrollPane scrollPane = new JScrollPane(table);
       
        panel2.add(scrollPane);

        panel2.add(join2);
        panel2.add(join);
        panel2.add(aiub);
        panel2.add(coursePlanner);
        panel2.add(signup);

        this.add(panel2);

        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                String command = ae.getActionCommand();
             

                if (login.getText().equals(command)) {
                String d = student.getText();
                String a =pass.getText();

                int index = us.userExists(d);
                if(index!=-1){
                    u = us.getuser(index, a );
                    
                    if (u != null && u.getdep().equals("admin")) { // Check if department is "admin"
                    adminpanel h = new adminpanel(al, de);
                    h.setVisible(true);
                    dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Password incorrect!","Login Failed" , JOptionPane.ERROR_MESSAGE);
                }
                  System.out.println(a);
                } else {

                    JOptionPane.showMessageDialog(null, "You are not an Admin", "Login Failed",
                            JOptionPane.ERROR_MESSAGE);

                    student.setText("");
                    pass.setText("");
                }
            }
        }
         });
        }
       
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == login) {
            login.setBackground(color1);
            login.setForeground(color2);
        } else if (e.getSource() == signup) {
            signup.setBackground(color2);
            signup.setForeground(color1);
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
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}