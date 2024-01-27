import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class coursedatas extends JFrame {
    private JTable courseTable;
    private DefaultTableModel tableModel;
    private JPanel p1, p2;
    login lg;
	users us;
	user u;

    public coursedatas(user u, users us, login lg) {
        super("Unique Course Data");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        

        String[] columnNames = {"Course Name", "Prerequisite 1", "Prerequisite 2", "Course Code", "Credit"};

        tableModel = new DefaultTableModel(columnNames, 0);
        courseTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(courseTable);

        JButton backButton = new JButton("Back");
        backButton.setBackground(Color.white);
        backButton.setForeground(new Color(8, 86, 147));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              new home(u,us,lg);
                dispose(); 
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);

        this.add(buttonPanel, "North");
        this.add(scrollPane);

        displayUniqueDataFromFile("Files/coursedata.txt");
    }

    private void displayUniqueDataFromFile(String filename) {
        Set<String> courses = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] rowData = line.split("\n");
                String courseName = rowData[0];
                String prereq1 = rowData[3];
                String prereq2 = rowData[4];
                String courseCode = rowData[1];
                String credit = rowData[2];

                if (!courses.contains(courseName)) {
                    courses.add(courseName);
                    Vector<Object> row = new Vector<>();
                    row.add(courseName);
                    row.add(prereq1);
                    row.add(prereq2);
                    row.add(courseCode);
                    row.add(credit);
                    tableModel.addRow(row);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}