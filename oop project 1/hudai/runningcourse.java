import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class runningcourse {
    public runningcourse() {

    
        String file1Path = "Files/all.txt";
        String file2Path = "Files/coursedata.txt";
        String outputPath = "matchingLines.txt";

        int columnToCompareFile1 = 1;
        int columnToCompareFile2 = 4;

        try (BufferedReader br1 = new BufferedReader(new FileReader(file1Path));
             BufferedReader br2 = new BufferedReader(new FileReader(file2Path));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {

            String line1, line2;

            while ((line1 = br1.readLine()) != null) {
                String[] columns1 = line1.split(",");

                if (columns1.length > columnToCompareFile1) {
                    String value1 = columns1[columnToCompareFile1].trim();

                    br2.mark(1024);
                    while ((line2 = br2.readLine()) != null) {
                        String[] columns2 = line2.split(",");

                        if (columns2.length > columnToCompareFile2) {
                            String value2 = columns2[columnToCompareFile2].trim();

                            if (value1.equals(value2)) {
                                System.out.println("Exact match found:");
                                System.out.println("File 1: " + line1);
                                System.out.println("File 2: " + line2);
                                System.out.println("------------------------");

                                writer.write("File 1: " + line1);
                                writer.newLine();
                                writer.write("File 2: " + line2);
                                writer.newLine();
                                writer.write("------------------------");
                                writer.newLine();
                                break;
                            }
                        }
                    }
                    br2.reset();
                } else {
                    System.out.println("Column index out of bounds in file 1");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
