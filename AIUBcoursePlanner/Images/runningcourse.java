package Images;
// import javax.swing.*;
// import javax.swing.table.DefaultTableModel;
// import java.awt.*;
// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.IOException;

// public class runningcourse extends JFrame {
//     private DefaultTableModel tableModel;
//     private JTable table;
//     private JLabel totalCreditLabel;
//     private int totalCredits;

//     public runningcourse() {
//         super("Course Selection");
//         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         this.setSize(800, 600);
//         this.setLocationRelativeTo(null);

//         JPanel topPanel = new JPanel();
//         topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
//         totalCreditLabel = new JLabel("Total Credits: 0");
//         topPanel.add(totalCreditLabel);

//         JPanel centerPanel = new JPanel();
//         centerPanel.setLayout(new BorderLayout());
//         tableModel = new DefaultTableModel(new String[]{"Course Name", "Credit"}, 0);
//         table = new JTable(tableModel);
//         JScrollPane scrollPane = new JScrollPane(table);
//         centerPanel.add(scrollPane, BorderLayout.CENTER);

//         JPanel buttonPanel = new JPanel();
//         buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
//         JButton addButton = new JButton("Add");
//         JButton deleteButton = new JButton("Delete");
//         buttonPanel.add(addButton);
//         buttonPanel.add(deleteButton);

//         this.add(topPanel, BorderLayout.NORTH);
//         this.add(centerPanel, BorderLayout.CENTER);
//         this.add(buttonPanel, BorderLayout.SOUTH);

//         addButton.addActionListener(e -> {
//             String courseName = JOptionPane.showInputDialog(this, "Enter Course Name:");
//             String creditsStr = JOptionPane.showInputDialog(this, "Enter Credits:");
//             int credits = 0;
//             try {
//                 credits = Integer.parseInt(creditsStr);
//             } catch (NumberFormatException ex) {
//                 JOptionPane.showMessageDialog(this, "Invalid credit input. Please enter a valid number.");
//             }
//             if (credits > 0 && courseName != null && !courseName.isEmpty()) {
//                 tableModel.addRow(new Object[]{courseName, credits});
//                 totalCredits += credits;
//                 updateTotalCreditLabel();
//             }
//         });

//         deleteButton.addActionListener(e -> {
//             int row = table.getSelectedRow();
//             if (row != -1) {
//                 String creditsStr = (String) tableModel.getValueAt(row, 1);
//                 int credits = Integer.parseInt(creditsStr);
//                 totalCredits -= credits;
//                 updateTotalCreditLabel();
//                 tableModel.removeRow(row);
//             } else {
//                 JOptionPane.showMessageDialog(this, "Please select a row to delete.");
//             }
//         });

//         readCourseDataFromFile(); // Read course data from file when the app starts
//         updateTotalCreditLabel();
//     }

//     private void readCourseDataFromFile() {
//         String filePath = "Files/coursedata.txt";
//         try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//             String line;
//             while ((line = br.readLine()) != null) {
//                 String[] rowData = line.split("\n");
//                 if (rowData.length == 11) {
//                     tableModel.addRow(new Object[]{rowData[0], rowData[2]});
//                     totalCredits += Integer.parseInt(rowData[2]);
//                 }
//             }
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }

//     private void updateTotalCreditLabel() {
//         totalCreditLabel.setText("Total Credits: " + totalCredits);
//     }

//     public static void main(String[] args) {

//             runningcourse app = new runningcourse();
//             app.setVisible(true);
     
//     }
// }
