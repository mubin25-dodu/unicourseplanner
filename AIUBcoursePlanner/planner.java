import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.List;
import java.util.Vector;

public class planner extends JFrame implements ActionListener, MouseListener {
    DefaultListModel<String> courseList = new DefaultListModel<>();
    JList<String> availableCourses;
    JLabel p, pp1, img, backgroundLabel, coursePlanner,aiub;
    JButton addButton, confirmButton, backButton , uploadImageButton, adminpanel, curriculum, showpass, planner, logout,
    home ,unihome,notice , delete;;
    JPanel panel,panel2;
    JTextField searchField;
    JButton searchButton;
    DefaultTableModel tableModel;
    JLabel totalCreditsLabel;
    int totalCredits = 0;
    JList<String> courseDetailsList;
    DefaultListModel<String> courseDetailsModel;
    Color color1, color2, color3, color4;
    Font font1, font2, font3, font4, font5;
    login lg;
    users us;
    user u;
    ImageIcon lgbt,backgroundImage;
    ImageIcon ppImage;
    Image temp;
    Image bg, tempimg;
    Image lgbg;
    JTable courseTable;

    public planner(user u, users us, login lg) {
        super("Planner");
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
       
        searchField = new JTextField();
        searchField.setBounds(110, 430, 150, 20);
        backgroundLabel.add(searchField);

        searchButton = new JButton("Search");
        searchButton.setBounds(270, 430, 80, 20);
        searchButton.addActionListener(this);
        backgroundLabel.add(searchButton);

  

        coursePlanner = new JLabel("Course Planner");
        coursePlanner.setFont(new Font(null, Font.PLAIN, 26));
        coursePlanner.setForeground(Color.WHITE);
        coursePlanner.setBounds(150, 30, 200, 30);
        backgroundLabel.add(coursePlanner);

       

       

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

                planner a = new planner(u,us,lg);
                a.setVisible(true);
                a.setLocationRelativeTo(null);
                // String file1Path = "Files/coursedata.txt"; // all data holding file
                // String file2Path = "Files/exported_courses.txt"; // running and compleated file
                // String outputPath = "File/planner-temp.txt"; // planner
                    dispose();
               
            }
        });
        panel.add(planner);
        backgroundLabel.add(panel);

        panel2 = new JPanel();
        panel2.setBounds(0, 90,1920,1000);

        availableCourses = new JList<>(courseList);
        availableCourses.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(availableCourses);
        scrollPane.setBounds(110, 110, 450, 300);
        backgroundLabel.add(scrollPane);

        courseDetailsModel = new DefaultListModel<>();
        courseDetailsList = new JList<>(courseDetailsModel);
        courseDetailsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane detailsScrollPane = new JScrollPane(courseDetailsList);
        detailsScrollPane.setBounds(630, 110, 650, 300);
        detailsScrollPane.setBackground(color2);
        detailsScrollPane.setForeground(color4);

        backgroundLabel.add(detailsScrollPane);

        addButton = new JButton("Add To Table");
        addButton.setBounds(670, 420, 150, 30);
        addButton.setFocusable(false);
        addButton.addActionListener(this);
        backgroundLabel.add(addButton);

        totalCreditsLabel = new JLabel("Total Credits: 0");
        totalCreditsLabel.setForeground(Color.white);
        totalCreditsLabel.setBackground(color4);
        totalCreditsLabel.setFont(font5);
        totalCreditsLabel.setBounds(110, 500, 200, 30);
        backgroundLabel.add(totalCreditsLabel);

        confirmButton = new JButton("Confirm");
        confirmButton.setBounds(870, 420, 150, 30);
        confirmButton.setFocusable(false);
        confirmButton.addActionListener(this);
        backgroundLabel.add(confirmButton);

        // backButton = new JButton("Back");
        // backButton.setBounds(370, 450, 150, 30);
        // backButton.setFocusable(false);
        // backButton.addActionListener(this);
        // backgroundLabel.add(backButton);

        // Table
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Course");
        tableModel.addColumn("Course Code");
        tableModel.addColumn("Credit");
        tableModel.addColumn("Prerequisite 1");
        tableModel.addColumn("Prerequisite 2");
        tableModel.addColumn("Section");
        tableModel.addColumn("Day 1");
        tableModel.addColumn("Time 1");
        tableModel.addColumn("Day 2");
        tableModel.addColumn("Time 2");
        tableModel.addColumn("Department");
        
        courseTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(courseTable);
        tableScrollPane.setBounds(110, 600, 1000, 200);
        tableScrollPane.setOpaque(false);
        tableScrollPane.setBackground(color4);
        backgroundLabel.add(tableScrollPane);

        // Read from the file and populate the available courses in the JList
        populateAvailableCourses("Files/planner-temp.txt");

        // Action listener for the available courses JList
        availableCourses.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                // When a row is selected, read the details and update the courseDetailsList
                int selectedIndex = availableCourses.getSelectedIndex();
                if (selectedIndex != -1) {
                    String selectedCourse = courseList.getElementAt(selectedIndex);

                    // Read details from the file for the selected course
                    String[] details = getCourseDetails(selectedCourse);

                    // Update the courseDetailsList
                    courseDetailsModel.clear();
                    for (String detail : details) {
                        courseDetailsModel.addElement(detail);
                    }
                }
            }
        });

        availableCourses.setModel(courseList);
    }

    // Method to read the file and populate the available courses
    private void populateAvailableCourses(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String cname1 = scanner.nextLine();
                String code1 = scanner.nextLine();
                String credit1 = scanner.nextLine();
                String prereq11 = scanner.nextLine();
                String prereq21 = scanner.nextLine();
                String sec1 = scanner.nextLine();
                String day11 = scanner.nextLine();
                String day21 = scanner.nextLine();
                String t11 = scanner.nextLine();
                String t21 = scanner.nextLine();
                String dep1 = scanner.nextLine();

                String courseEntry = cname1 + " - " + credit1;

                // Check if the course name is already in the courseList
                if (!courseList.contains(courseEntry)) {
                    courseList.addElement(courseEntry);
                }

                // Skip lines to move to the next course
                while (true) {
                    String nextLine = scanner.nextLine();
                    if (nextLine.isEmpty()) {
                        break; // Break if an empty line is encountered
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            // Handle the case where there are no more lines
        }
    }

    // Method to get details for a selected course from the file
    // Method to get details for a selected course from the file
private String[] getCourseDetails(String selectedCourse) {
    List<String> detailsList = new ArrayList<>();

    try (Scanner scanner = new Scanner(new File("Files/planner-temp.txt"))) {
        while (scanner.hasNextLine()) {
            String cname1 = scanner.nextLine();
            String code1 = scanner.nextLine();
            String credit1 = scanner.nextLine();
            String prereq11 = scanner.nextLine();
            String prereq21 = scanner.nextLine();
            String sec1 = scanner.nextLine();
            String day11 = scanner.nextLine();
            String day21 = scanner.nextLine();
            String t11 = scanner.nextLine();
            String t21 = scanner.nextLine();
            String dep1 = scanner.nextLine();

            String courseEntry = cname1 + " - " + credit1;

            // Check if the current course matches the selected course
            if (courseEntry.equals(selectedCourse)) {
                // Add details for the selected course to the list
             

               
                detailsList.add(cname1);           
                detailsList.add(code1);                
                detailsList.add(credit1);
                detailsList.add(prereq11);
                detailsList.add(prereq21);
                detailsList.add(sec1);
                detailsList.add(day11);
                detailsList.add(day21);
                detailsList.add(t11);
                detailsList.add(t21);
                detailsList.add(dep1);
                detailsList.add("---------------------------------------------------------");
                
                } 

            // Skip lines to move to the next course
            while (true) {
                String nextLine = scanner.nextLine();
                if (nextLine.isEmpty()) {
                    break; // Break if an empty line is encountered
                }
            }
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (NoSuchElementException e) {
        // Handle the case where there are no more lines
    }

    // Convert the list to an array before returning
    return detailsList.toArray(new String[0]);
}

// Method to add a course to the JTable row by row
private void addCourseToTable(String[] courseDetails) {
    // Add matched data to the tableModel column by column
    Vector<String> rowData = new Vector<>();
    for (String detail : courseDetails) {
        // Assuming each detail is separated by " - "
        String[] parts = detail.split(" - ");
        rowData.addAll(Arrays.asList(parts));
    }

    // Add the rowData to the tableModel
    tableModel.addRow(rowData);

    // Update the total credits label
    updateTotalCredits();
}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            int selectedIndex = availableCourses.getSelectedIndex();
            if (selectedIndex != -1) {
                String selectedCourse = courseList.getElementAt(selectedIndex);
                String[] courseDetails = getCourseDetails(selectedCourse);
                addCourseToTable(courseDetails);
            }
        } else if (e.getSource() == confirmButton) {
          
            if (tableModel.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Please add courses to the table before confirming.");
              
                return;
            }
    
            // Check for clashes
            if (hasClashes()) {
                JOptionPane.showMessageDialog(this, "Clashing courses found. Please resolve the clashes before confirming.");
                return;
            }
    
            // Save table data to a file
            saveTableToFile("Files/running.txt");
            saveTableToFile("Files/all.txt");
            clearTable();
        } String filePath = "Files/planner-temp.txt";
                File file = new File(filePath);
                if (file.exists()) {
                    if (file.delete()) {
                        System.out.println("File deleted successfully.");
                    } else {
                        System.out.println("Failed to delete the file.");
                    }
                }
                

                // Create a new file
                try {
                    if (file.createNewFile()) {
                        System.out.println("File created successfully.");
                    } else {
                        System.out.println("Failed to create the file.");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                 
    }

    private boolean hasClashes() {
    Set<String> sections = new HashSet<>();
    for (int i = 0; i < tableModel.getRowCount(); i++) {
        String section = (String) tableModel.getValueAt(i, 1); // Assuming section is in the second column
        if (sections.contains(section)) {
            return true; // Clash found
        }
        sections.add(section);
    }
    return false; // No clashes
}

private void saveTableToFile(String fileName) {
    try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
        
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            for (int j = 0; j < tableModel.getColumnCount(); j++) {
                String value = (String) tableModel.getValueAt(i, j);
                writer.print(value);
                if (j < tableModel.getColumnCount() - 1) {
                    writer.print("\n");
                }
            }writer.println();
            writer.println();
            
        }
        writer.println(); // Add an empty line to separate course entries
        JOptionPane.showMessageDialog(this, "Data appended to " + fileName);
    } catch (IOException ex) {
        ex.printStackTrace();
        System.out.println("Failed to append data to " + fileName);
    }
}


// Method to clear the table
private void clearTable() {
    tableModel.setRowCount(0);
    updateTotalCredits();
    totalCreditsLabel.setText("Total Credits: 0");
}

private void updateTotalCredits() {
    int total = 0;

    // Iterate through the rows and update total credits
    for (int i = 0; i < tableModel.getRowCount(); i++) {
        String creditString = (String) tableModel.getValueAt(i, 2); // Assuming credit is in the second column
        total += Integer.parseInt(creditString);
    }

    // Update the total credits label
    totalCreditsLabel.setText("Total Credits: " + total);
}
    

    public static void main(String[] args) {
        user sampleUser = new user();
        users sampleUsers = new users();
        login sampleLogin = new login(sampleUsers);
        new planner(sampleUser, sampleUsers, sampleLogin).setVisible(true);
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
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
    public void mouseExited(java.awt.event.MouseEvent e) {
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
        } }
}