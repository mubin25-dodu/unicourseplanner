import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class planner extends JFrame implements ActionListener {
    DefaultListModel<String> courselist = new DefaultListModel<>();
    JList<String> availablecourse;
    JButton addButton, refresh,checkoutButton, back;
    JPanel panel;
    DefaultTableModel tableModel;
    JLabel totalCreditsLabel;
    int totalCredits = 0;
    DefaultListModel<String> confirmedCourses = new DefaultListModel<>();
    login lg;
	users us;
	user u;

//"Files/"+ u.getcontact()+"planner.txt" reading
//"Files/"+ u.getcontact()+"all.txt" writing
//"Files/"+ u.getcontact()+"running.txt" writing


    public planner() {
        super("Planner");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 700);
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.lg = lg;
		this.u = u;
		this.us = us;
       

        panel = new JPanel();
        panel.setLayout(null);

        availablecourse = new JList<>(courselist);
        availablecourse.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(availablecourse);
        scrollPane.setBounds(30, 20, 300, 300);
        panel.add(scrollPane);

        addButton = new JButton("Add Course");
        addButton.setBounds(30, 350, 150, 30);
        addButton.setFocusable(false);
        addButton.addActionListener(this);
        panel.add(addButton);

        // refresh = new JButton("Add Course");
        // refresh.setBounds(30, 350, 150, 30);
        // refresh.setFocusable(false);
        // refresh.addActionListener(this);
        // panel.add(refresh);

        totalCreditsLabel = new JLabel("Total Credits: 0");
        totalCreditsLabel.setBounds(50, 500, 200, 30);
        panel.add(totalCreditsLabel);

        checkoutButton = new JButton("Checkout");
        checkoutButton.setBounds(200, 350, 150, 30);
        checkoutButton.setFocusable(false);
        checkoutButton.addActionListener(this);
        panel.add(checkoutButton);

        back = new JButton("Back");
        back.setBounds(370, 350, 150, 30);
        back.setFocusable(false);
        back.addActionListener(this);
        panel.add(back);

        createCourseTable();
        this.add(panel);

        courselist = readFromFile("Files/planner.txt");
        availablecourse.setModel(courselist);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            addSelectedCourse();
        } else if (e.getSource() == checkoutButton) {
            checkoutSelectedCourses();
        } else if (e.getSource() == back) {
                home h = new home(u,us,lg);
                h.setVisible(true);
                h.setLocationRelativeTo(null);
                dispose();
            }
    }

    private void addSelectedCourse() {
        String selectedCourse = availablecourse.getSelectedValue();
        if (selectedCourse != null && !confirmedCourses.contains(selectedCourse)) {
            String[] courseDetails = selectedCourse.split(" - Section: ");
            String courseData = getCourseData(courseDetails[0], courseDetails[1]);
    
            if (!courseData.equals("Not found")) {
                String[] rowData = courseData.split(",");
                int clashRowIndex = isCourseDetailsMatch(rowData[0], rowData[3], rowData[4], rowData[1], rowData[2]);
                if (clashRowIndex != -1) {
                    JOptionPane.showMessageDialog(null, "Clash with another course: "
                            + tableModel.getValueAt(clashRowIndex, 0));
                } else {
                    tableModel.addRow(rowData);
                    updateTotalCredits(Integer.parseInt(rowData[2]));
                    confirmedCourses.addElement(selectedCourse);
                    availablecourse.setSelectedValue(null, false);
                }
            }
        } else if (selectedCourse != null && confirmedCourses.contains(selectedCourse)) {
            JOptionPane.showMessageDialog(null, "This course has already been selected.");
        } else {
            JOptionPane.showMessageDialog(null, "Please select a course.");
        }
    }
    
    private int isCourseDetailsMatch(String cname, String t1, String t2, String d1, String d2) {
        String filename = "Files/planner.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int row = 0;
            while ((line = br.readLine()) != null) {
                String[] courseData = line.split("\n");
                if (courseData.length >= 6 && courseData[0].equals(cname) && courseData[7].equals(t1)
                        && courseData[8].equals(t2) && courseData[5].equals(d1) && courseData[6].equals(d2)) {
                    return row; // clash found, return the row index
                }
                row++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1; // no clash found
    }
    private void updateTotalCredits(int credits) {
        totalCredits += credits;
        totalCreditsLabel.setText("Total Credits: " + totalCredits);
    }

    private void checkoutSelectedCourses() {
        int confirmDialog = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to checkout and clear selected courses?",
                "Checkout Confirmation",
                JOptionPane.YES_NO_OPTION
        );
    
        if (confirmDialog == JOptionPane.YES_OPTION) {
            exportSelectedCoursesToFile("Files/all.txt");
            exportSelectedCoursesToFiler("Files/running.txt");
            clearTable();
        }
    }

    private void exportSelectedCoursesToFile(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (int i = 0; i < confirmedCourses.size(); i++) {
                String selectedCourse = confirmedCourses.getElementAt(i);
                String[] courseDetails = selectedCourse.split(" - Section: ");
                String courseData = getCourseData(courseDetails[0], courseDetails[1]);
    
                if (!courseData.equals("Not found")) {
                    writer.write(courseData + "\n");
                }
            }
            JOptionPane.showMessageDialog(null, "Selected courses exported to 'exported_courses.txt'");
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occurred while exporting courses.");
        }

    }


    private void clearFileContent(String filePath) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        writer.write(""); // Clears the content by writing an empty string
        writer.close();
    }
    
    private void exportSelectedCoursesToFiler(String filename2) {
        try (FileWriter writer = new FileWriter(filename2)) {
            for (int i = 0; i < confirmedCourses.size(); i++) {
                String selectedCourse = confirmedCourses.getElementAt(i);
                String[] courseDetails = selectedCourse.split(" - Section: ");
                String courseData = getCourseData(courseDetails[0], courseDetails[1]);
    
                if (!courseData.equals("Not found")) {
                    writer.write(courseData + "\n");
                }
            }
            JOptionPane.showMessageDialog(null, "Selected courses exported to 'exported_courses.txt'");
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occurred while exporting courses.");
        }
    }
 
    private String getCourseData(String courseName, String section) {
        String filename = "Files/planner.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] courseData = line.split(",");
                if (courseData.length >= 6 && courseData[0].equals(courseName) && courseData[5].equals(section)) {
                    return line;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Not found";
    }

    private void createCourseTable() {
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Course Name");
        tableModel.addColumn("Section");
        tableModel.addColumn("Credit Count");

        JTable courseTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(courseTable);
        scrollPane.setBounds(400, 20, 350, 300);
        panel.add(scrollPane);
    }

    private void clearTable() {
        tableModel.setRowCount(0);
        totalCredits = 0;
        totalCreditsLabel.setText("Total Credits: " + totalCredits);
    }

    private DefaultListModel<String> readFromFile(String filename) {
        DefaultListModel<String> listModel = new DefaultListModel<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] courseData = line.split(",");
                if (courseData.length >= 6) {
                    String courseName = courseData[0];
                    String section = courseData[5];
                    String displayText = courseName + " - Section: " + section;
                    listModel.addElement(displayText);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
        
        File fileToDelete = new File(filename);
        boolean fileDeleted = fileToDelete.delete();
        if (fileDeleted) {
            System.out.println("File deleted successfully: " + filename);
        } else {
            System.out.println("Failed to delete the file: " + filename);
        }

        return listModel;
    }

    public static void main(String[] args) {
      
            planner planner = new planner();
            planner.setVisible(true);
   
    }
}