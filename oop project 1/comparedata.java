import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class comparedata {
    File file1 = new File("Files/all.txt");
    File file2 = new File("Files/coursedata.txt");
    File file3 = new File("Files/planner.txt");

    public comparedata() {
        try (Scanner s = new Scanner(file1)) {
            Scanner sc = new Scanner(file2); // Declare Scanner outside the loop

            while (s.hasNextLine()) {
                String line0 = s.nextLine();
                String line1 = s.nextLine();
                String line2 = s.nextLine();
                String line3 = s.nextLine();
                String line4 = s.nextLine();
                String line5 = s.nextLine();
                String line6 = s.nextLine();
                String line7 = s.nextLine();
                String line8 = s.nextLine();
                String line9 = s.nextLine();
                String line10 = s.nextLine();
                String line100 = s.nextLine();

                String cname = line0.substring(0);
                String code = line1.substring(0);
                String credit = line2.substring(0);
                String prereq1 = line3.substring(0);
                String prereq2 = line4.substring(0);
                String sec = line5.substring(0);
                String day1 = line6.substring(0);
                String day2 = line7.substring(0);
                String t1 = line8.substring(0);
                String t2 = line9.substring(0);
                String dep = line10.substring(0);

                try (FileWriter fw = new FileWriter(file3, true)) {
                    while (sc.hasNextLine()) {
                        String line11 = sc.nextLine();
                        String line12 = sc.nextLine();
                        String line13 = sc.nextLine();
                        String line14 = sc.nextLine();
                        String line15 = sc.nextLine();
                        String line16 = sc.nextLine();
                        String line17 = sc.nextLine();
                        String line18 = sc.nextLine();
                        String line19 = sc.nextLine();
                        String line20 = sc.nextLine();
                        String line21 = sc.nextLine();
                        String line22 = sc.nextLine();

                        String cname1 = line11.substring(0);
                        String code1 = line12.substring(0);
                        String credit1 = line13.substring(0);
                        String prereq11 = line14.substring(0);
                        String prereq21 = line15.substring(0);
                        String sec1 = line16.substring(0);
                        String day11 = line17.substring(0);
                        String day21 = line18.substring(0);
                        String t11 = line19.substring(0);
                        String t21 = line20.substring(0);
                        String dep1 = line21.substring(0);

                        if (code.equals(prereq11) || code.equals(prereq21) || prereq11.equals("0")) {
                            fw.write(line11 + "\n");
                            fw.write(line12 + "\n");
                            fw.write(line13 + "\n");
                            fw.write(line14 + "\n");
                            fw.write(line15 + "\n");
                            fw.write(line16 + "\n");
                            fw.write(line17 + "\n");
                            fw.write(line18 + "\n");
                            fw.write(line19 + "\n");
                            fw.write(line20 + "\n");
                            fw.write(line21 + "\n\n");

                            // Print the content to the console for debugging
                            System.out.println(line11);
                            System.out.println(line12);
                            System.out.println(line13);
                            System.out.println(line14);
                            System.out.println(line15);
                            System.out.println(line16);
                            System.out.println(line17);
                            System.out.println(line18);
                            System.out.println(line19);
                            System.out.println(line20);
                            System.out.println(line21);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // Close and reinitialize the Scanner for file2 after each iteration of the outer loop
                sc.close();
                sc = new Scanner(file2);
            }
            
            // Close the Scanner for file2 outside the loop
            sc.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        comparedata program = new comparedata();
        System.out.println("Program executed successfully!");
    }
}
