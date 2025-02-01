import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class home extends JFrame implements ActionListener, MouseListener {
    JPanel mainPanel, panel, panel2, panel3, panel4, panel5;
    JTextField student;
    JLabel p, pp1, img, backgroundLabel, aiub, id, pass, name, mail, dep,
            classtime, cc, rc, coursePlanner, imageLabel;
    ImageIcon pp, backgroundImage;
    JButton uploadImageButton, adminpanel, curriculum, showpass, planner, logout,
            home ,unihome,notice , delete;
    Color color1, color2, color3, color4;
    Font font1, font2, font3, font4, font5;
    Image bg, tempimg, p1, p2;
    ImageIcon lgbt;
    ImageIcon ppImage;
    Image temp;
    Image lgbg;
    String pa="",hpass="";
	login lg;
	users us;
	user u;

    public home(user u, users us, login lg) {
   

        super("Home");
        this.setSize(1920, 1080);
        // this.setBackground(Color.MAGENTA);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximizes the window to fullscreen
        // this.setUndecorated(true); // Removes window decorations (title bar, borders)
      
        this.lg = lg;
		this.u = u;
		this.us = us;
       
        // mainPanel = new JPanel();
        // mainPanel.setLayout(new BorderLayout()); // Use BorderLayout for better component arrangement
        // mainPanel.setPreferredSize(new Dimension(1920, 1080)); // Set the initial preferred size
        // mainPanel.setBackground(color1);
        // mainPanel.setForeground(color4);

        backgroundImage = new ImageIcon("images/IMG_7611.jpg");
        backgroundLabel = new JLabel(backgroundImage);
        bg = backgroundImage.getImage();
        tempimg = bg.getScaledInstance(1920, 850, Image.SCALE_SMOOTH);
        backgroundImage = new ImageIcon(tempimg);
        backgroundLabel.setIcon(backgroundImage);
        backgroundLabel.setBounds(0, 0, 1920, 850);
        this.add(backgroundLabel);

        color1 = new Color(255, 255, 255); // white
        color3 = new Color(8, 86, 147, 235); // panel
        color4 = new Color(8, 86, 147); // dark blue
        color2 = new Color(8, 86, 147, 50);// dark blue panel

        font1 = new Font(null, Font.BOLD, 14); // button
        font2 = new Font(null, Font.BOLD, 16);
        font3 = new Font(null, Font.BOLD, 16);
        font4 = new Font(null, Font.BOLD, 16);
        font5 = new Font(null, Font.BOLD, 16); // TextButtons after

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(color4);
        panel.setBounds(0, 0, 1920, 70);

        aiub = new JLabel("AIUB");
        aiub.setFont(new Font(null, Font.PLAIN, 60));
        aiub.setForeground(Color.WHITE);
        aiub.setBounds(10, 0, 200, 65);
        backgroundLabel.add(aiub);

        coursePlanner = new JLabel("Course Planner");
        coursePlanner.setFont(new Font(null, Font.PLAIN, 26));
        coursePlanner.setForeground(Color.WHITE);
        coursePlanner.setBounds(150, 30, 200, 30);
        panel.add(coursePlanner);

       

        backgroundLabel.add(panel);

        curriculum = new JButton("Curriculum");
        curriculum.setBorderPainted(false);
        curriculum.setFocusPainted(false);
        // curriculum.setContentAreaFilled(false);
        curriculum.setFont(font1);
        curriculum.setForeground(color1);
        curriculum.setContentAreaFilled(false);
        curriculum.setBackground(null);
        curriculum.addMouseListener(this);
        curriculum.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new coursedatas(u,us,lg); 
                new comparedata(); 

                setVisible(true);
            }
        });
        curriculum.setBounds(450, 35, 130, 30);

        panel.add(curriculum);

        unihome = new JButton("Portal");
        // unihome.setBorderPainted(false);
        // unihome.setFocusPainted(false);
        unihome.setFont(font1);
        unihome.setForeground(color1);
        // unihome.setContentAreaFilled(false);
        unihome.setBackground(null);
        // unihome.addMouseListener(this);
        unihome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new uni(); 
                setVisible(true);
            }
        });
        unihome.setBounds(1050, 35, 130, 30);

        panel.add(unihome);


        home = new JButton("Home");
        home.setBackground(null);
        home.setForeground(color1);
        home.setBorderPainted(false);
        home.setFocusPainted(false);
        home.setFont(font1);
        home.setBounds(900, 35, 130, 30);
        home.addMouseListener(this);
        home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                home h = new home(u,us,lg);
                h.setVisible(true);
                h.setLocationRelativeTo(null);
                dispose();
            }
        });
        panel.add(home);

        // curriculum.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         CourseData.main(null);
        //     }
        // });

        adminpanel = new JButton("Admin");
        adminpanel.setBorderPainted(false);
        adminpanel.setFocusPainted(false);
        // curriculum.setContentAreaFilled(false);
        adminpanel.setFont(font1);
        adminpanel.setForeground(color1);
        adminpanel.setBackground(null);
        adminpanel.setBounds(1420, 35, 110, 30);
        adminpanel.addMouseListener(this);
        adminpanel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adminlogin a = new adminlogin();
                a.setVisible(true);
                a.setLocationRelativeTo(null);
                dispose();
            }
        });
        panel.add(adminpanel);

        planner = new JButton("Planner");
        planner.setFont(font1);
        planner.setBackground(null);
        planner.setForeground(color1);
        planner.setBounds(700, 35, 110, 30);
        planner.setBorderPainted(false);
        planner.setFocusPainted(false);
        planner.addMouseListener(this);
        planner.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                planner a = new planner();
                a.setVisible(true);
                a.setLocationRelativeTo(null);
                // String file1Path = "Files/coursedata.txt"; // all data holding file
                // String file2Path = "Files/exported_courses.txt"; // running and compleated file
                // String outputPath = "File/planner.txt"; // planner
        
                 
                    dispose();
               
            }
        });
        panel.add(planner);

        panel2 = new JPanel();
        panel2.setBounds(30, 90, 640, 200);
        panel2.setBackground(color2);
        panel2.setLayout(null);
        panel2.setOpaque(true);

        pp = new ImageIcon("Images/pp.jpg");
        pp1 = new JLabel(pp);
        p1 = pp.getImage();
        p2 = p1.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        pp = new ImageIcon(p2);
        pp1.setBounds(25, 15, 190, 140);
        panel2.add(pp1);

        uploadImageButton = new JButton("Upload Image");
        uploadImageButton.setFont(font1);
        uploadImageButton.setBackground(color4);
        uploadImageButton.setFocusable(false);
        uploadImageButton.setBorderPainted(false);
        uploadImageButton.setFocusPainted(false);
        uploadImageButton.setForeground(color1);
        uploadImageButton.setBounds(55, 160, 130, 30);
        uploadImageButton.addMouseListener(this);
        uploadImageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectAndDisplayImage();
                revalidate();
                repaint();
            }
        });
        panel2.add(uploadImageButton);

  

        lgbt = new ImageIcon("Images/logout.png");
        logout = new JButton(" Log out", lgbt);
        lgbg = lgbt.getImage();
        temp = lgbg.getScaledInstance(30, 25, Image.SCALE_SMOOTH);
        lgbt = new ImageIcon(temp);
        logout.setIcon(lgbt);
        logout.setForeground(Color.white);
        logout.setFont(font1);
        logout.setBackground(new Color(8, 86, 147));
        logout.setBounds(250, 160, 130, 30);
        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login a = new login(us);
                a.setVisible(true);
                dispose();
                a.setLocationRelativeTo(null);
                revalidate();
                repaint();
            }
        });


        // showpass = new JButton("Show");
        // showpass.setFocusable(false);
        // showpass.setForeground(color4);
        // showpass.setFont(font1);
        // showpass.setBackground(Color.white);
        // showpass.addMouseListener(this);
        // showpass.setBounds(450, 96, 150, 30);
        // showpass.addMouseListener(this);
        // showpass.addActionListener(this);
        // panel2.add(showpass);

        delete = new JButton("Delete Profile!");
        delete.setFocusable(false);
        delete.setForeground(color1);
        delete.setFont(font1);
        delete.setBackground(color4);
        delete.addMouseListener(this);
        delete.setBounds(450, 160, 150, 30);
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int dialog = JOptionPane.YES_NO_OPTION;
                int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete your account?", "Delete account?", dialog);
                
                if (result == 0) {

                   // us.deleteUser(u); 
                    us.deleteUserFile(u.getcontact()); 
                    JOptionPane.showMessageDialog(null, "User deleted!");
                    new Message();
                    dispose();
                    setLocationRelativeTo(null);
                    revalidate();
                repaint();
                }
            }
        });
  
         panel2.add(delete);


        panel2.add(logout);

      
        
        String pa = u.getpassword();
        int passlength = pa.length();
        for( int i=0; i<passlength;i++) {
            hpass+='*';
        }

        name = new JLabel("Name-"+u.getname());
        name.setBackground(color2);
        name.setForeground(color1);
        name.setBounds(250, 35, 200, 30);
        name.setFont(font3);

    
        pass = new JLabel("Password-"+hpass);
        pass.setBackground(color2);
        pass.setForeground(color1);
        pass.setBounds(250, 97, 200, 30);
        pass.setFont(font3);
        panel2.add(pass);

        mail = new JLabel("Email/Phone-"+ u.getcontact());
        mail.setBackground(color2);
        mail.setForeground(color1);
        mail.setBounds(250, 130, 200, 30);
        mail.setFont(font3);
        panel2.add(mail);

        id = new JLabel("ID-"+u.getid());
        id.setBackground(color2);
        id.setForeground(color1);
        id.setBounds(250, 8, 200, 30);
        id.setFont(font3);

        dep = new JLabel("Depertmant-"+u.getdep());
        dep.setBackground(color2);
        dep.setForeground(color1);
        dep.setBounds(250, 65, 200, 30);
        dep.setFont(font3);

        panel2.add(dep);
        panel2.add(id);
        panel2.add(name);

        backgroundLabel.add(panel2);
        panel3 = new JPanel();
        panel3.setBounds(30, 330, 760, 410);
        panel3.setBackground(color2);
        panel3.setLayout(null);
        panel3.setOpaque(true);

        

        cc = new JLabel("Course Completed");
        cc.setBackground(color2);
        cc.setForeground(color1);
        cc.setFont(font4);
        cc.setBounds(5, 5, 200, 100);
        displayFileContentAsLabels(panel3, "Files/complete.txt");

        panel3.add(cc);
        backgroundLabel.add(panel3);

        panel4 = new JPanel();
        panel4.setBounds(860, 330, 640, 410);
        panel4.setBackground(color2);
        panel4.setLayout(null);
        panel4.setOpaque(true);
        // panel4.setBorder(new RoundedBorder(20));

        rc = new JLabel("Running Course");
        rc.setBackground(color2);
        rc.setForeground(color1);
        rc.setFont(font4);
        rc.setBounds(5, 0, 200, 50);
        displayFileContentAsLabels();

        panel4.add(rc);

        backgroundLabel.add(panel4);

        JButton compleate = new JButton("Add to Compleate");
        compleate.setBounds(10,300,200,40);
        compleate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int dialog = JOptionPane.YES_NO_OPTION;
                int result = JOptionPane.showConfirmDialog(null, "Add to complete course?", "Add!", dialog);

                if (result == JOptionPane.YES_OPTION) {
                    File sourceFilePath= new File("Files/running.txt");
                    File destinationFilePath = new File("Files/complete.txt");
                    File allFilePath = new File("Files/all.txt");
                    appendDataToFile(allFilePath, readFileContent(destinationFilePath.getAbsolutePath()));
                    deleteAndMoveData(sourceFilePath, destinationFilePath);
                    refreshFrame();
                    new comparedata();
               
                   
                    revalidate();
                    repaint();
                
                }
            }
        });
        panel4.add(compleate);
        panel5 = new JPanel();
        panel5.setBounds(720, 90, 780, 200);
        panel5.setBackground(color2);
        panel5.setLayout(null);
        panel5.setOpaque(true);

        classtime = new JLabel("Class Schedule");
        classtime.setBackground(color2);
        classtime.setForeground(color1);
        classtime.setFont(font4);
        classtime.setBounds(15, 10, 200, 20);
        panel5.add(classtime);

//         JScrollPane scrollPane = new JScrollPane(mainPanel);
//         scrollPane.setSize(2, 1080);
// scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
// scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

// setContentPane(scrollPane);


           
        backgroundLabel.add(panel5);
      

    }

    private void selectAndDisplayImage() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            try {
                String imagePath = selectedFile.getAbsolutePath();
                ImageIcon originalIcon = new ImageIcon(imagePath);
                Image originalImage = originalIcon.getImage();

                pp1.setPreferredSize(new Dimension(150, 120));

                Image resizedImage = originalImage.getScaledInstance(pp1.getWidth(),
                        pp1.getHeight(),
                        Image.SCALE_SMOOTH);
                ImageIcon resizedIcon = new ImageIcon(resizedImage);

                pp1.setIcon(resizedIcon);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }public void displayCompletedCourseContentAsLabels() {
        // Read from the file and get the content
        String fileContent = readFileContent("Files/completed_course.txt");
    
        String[] lines = fileContent.split("\n");
    
        int labelYPosition = 40;
    
        for (String line : lines) {
            JLabel fileContentLabel = new JLabel(line);
            fileContentLabel.setForeground(Color.WHITE);
            fileContentLabel.setFont(new Font(null, Font.BOLD, 30));
            fileContentLabel.setBounds(15, labelYPosition, 610, 50); // Adjust the bounds as needed
    
            panel3.add(fileContentLabel);
    
            labelYPosition += 25; // Increase Y position for the next label
        }
    }
    
    private String readFileContent1String(String filePath) {
        StringBuilder content = new StringBuilder();
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
    
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine()).append("\n");
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return content.toString();
    }public void displayFileContentAsLabels(JPanel panel, String filePath) {
        // Read from the file and get the content
        String fileContent = readFileContent(filePath);
    
        String[] lines = fileContent.split("\n");
    
        int labelYPosition = 40;
    
        for (String line : lines) {
            JLabel fileContentLabel = new JLabel(line);
            fileContentLabel.setForeground(Color.WHITE);
            fileContentLabel.setFont(new Font(null, Font.BOLD, 30));
            fileContentLabel.setBounds(15, labelYPosition, 610, 50); // Adjust the bounds as needed
    
            panel.add(fileContentLabel);
    
            labelYPosition += 25; // Increase Y position for the next label
        }
    }
    



    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
         }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == showpass){
			pass.setText("Password: " + hpass);		
		}
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getSource() == showpass){
			pass.setText("Password: " + pass);		
		}
    }

    @Override
    public void mouseEntered(MouseEvent e) {

        if (e.getSource() == logout) {
            logout.setBackground(new Color(8, 86, 166));

        } else if (e.getSource() == planner) {
            planner.setFont(font5);
        } else if (e.getSource() == curriculum) {
            curriculum.setFont(font5);
        } else if (e.getSource() == adminpanel) {
            adminpanel.setFont(font5);
        } else if (e.getSource() == home) {
            home.setFont(font5);
        } else if (e.getSource() == adminpanel) {
            adminpanel.setFont(font5);
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == logout) {
            logout.setBackground(new Color(8, 86, 147));
        } else if (e.getSource() == planner) {
            planner.setFont(font1);
        } else if (e.getSource() == curriculum) {
            curriculum.setFont(font1);
        } else if (e.getSource() == adminpanel) {
            adminpanel.setFont(font1);
        } else if (e.getSource() == home) {
            home.setFont(font1);
        } else if (e.getSource() == adminpanel) {
            adminpanel.setFont(font1);
        }
    }
public void displayFileContentAsLabels() {
    // Read from the file and get the content
    String fileContent = readFileContent("Files/running.txt");

    String[] lines = fileContent.split("\n");

    int labelYPosition = 40; 
  

    for (String line : lines) {
        JLabel fileContentLabel = new JLabel(line);
        fileContentLabel.setForeground(Color.WHITE);
        fileContentLabel.setFont(new Font(null, Font.BOLD, 30));
        fileContentLabel.setBounds(15, labelYPosition, 610, 50); // Adjust the bounds as needed

        panel4.add(fileContentLabel);

        labelYPosition += 25; // Increase Y position for the next label
    }
}

private String readFileContent(String filePath) {
    StringBuilder content = new StringBuilder();
    try {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            content.append(scanner.nextLine()).append("\n");
        }
        scanner.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    return content.toString();
} 

public void deleteAndMoveData(File sourceFilePath, File destinationFilePath) {
    try {
        BufferedReader reader = new BufferedReader(new FileReader(sourceFilePath));
        StringBuilder content = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }
        reader.close();

        BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFilePath));
        writer.write(content.toString());
        writer.close();

        // Clear the source file
        clearFileContent(sourceFilePath);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
private void appendDataToFile(File file, String data) {
    try {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
        writer.append(data);
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

private void clearFileContent(File file) {
    try {
        FileWriter fw = new FileWriter(file);
        fw.write(""); // Clearing the file content
        fw.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public void refreshFrame() {
        revalidate(); 
        repaint();   
    }
    // public static void main(String[] arg) {
    //     users us = new users();
    //     user u= new user();
    //     login lg = new login(us);
    //     home h = new home(u,us,lg);
    //     h.setVisible(true);
    // }

}