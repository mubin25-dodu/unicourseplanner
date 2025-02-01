import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.io.*;

abstract class tableadminpanel {
    
    public static void saveDataToFile(DefaultTableModel model, String filePath) {
        File file = new File(filePath);
        try (FileWriter writer = new FileWriter(file)) {
            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    writer.write(model.getValueAt(i, j).toString());
                    if (j < model.getColumnCount() - 1) {
                        writer.write(",");
                    }
                }
                writer.write("\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

   
    public static void refreshTable(DefaultTableModel model, String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            model.setRowCount(0); // Clear existing data from the table
    
            String line;
            while ((line = br.readLine()) != null) {
                String[] rowData = line.split(",");
                if (rowData.length == 11) {
                    model.addRow(rowData); // Add each row of data to the table model
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteSelectedRow(DefaultTableModel model, int selectedRow) {
        if (selectedRow >= 0) {
            model.removeRow(selectedRow);
        }
    }public static void setTableEditable(JTable table) {
        table.setDefaultEditor(Object.class, new DefaultCellEditor(new JTextField()));
        table.getModel().addTableModelListener(e -> {
            int row = e.getFirstRow();
            int column = e.getColumn();
            if (row >= 0 && column >= 0) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                String updatedValue = model.getValueAt(row, column).toString();
                 saveDataToFile(model, "Files/coursedata.txt");
            }
        });
    }
}