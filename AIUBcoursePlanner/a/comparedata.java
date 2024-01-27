import java.io.*;

public class comparedata {

    File file1 = new File("Files/all.txt");
    File file2 = new File("Files/coursedata.txt");
    File file3 = new File("Files/planner-temp.txt");

    public comparedata() {
        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1));
             FileWriter fw = new FileWriter(file3, true)) {
            String line1;
            // Use a loop to read file1
            while ((line1 = reader1.readLine()) != null) {
                String cname = line1;
                String code = reader1.readLine();
                String credit = reader1.readLine();
                String prereq1 = reader1.readLine();
                String prereq2 = reader1.readLine();
                String sec = reader1.readLine();
                String day1 = reader1.readLine();
                String day2 = reader1.readLine();
                String t1 = reader1.readLine();
                String t2 = reader1.readLine();
                String dep = reader1.readLine();
                if (code != null) {
                    // matching data
                    StringBuilder matchingData = new StringBuilder();
                    try (BufferedReader reader2 = new BufferedReader(new FileReader(file2))) {
                        String line2;
                        while ((line2 = reader2.readLine()) != null) {
                            String cname1 = line2;
                            String code1 = reader2.readLine();
                            String credit1 = reader2.readLine();
                            String prereq11 = reader2.readLine();
                            String prereq21 = reader2.readLine();
                            String sec1 = reader2.readLine();
                            String day11 = reader2.readLine();
                            String day21 = reader2.readLine();
                            String t11 = reader2.readLine();
                            String t21 = reader2.readLine();
                            String dep1 = reader2.readLine();
                            String h = reader2.readLine();
                            if ((code.equals(prereq11) || code.equals(prereq21))) {
                                matchingData.append(cname1).append("\n");
                                matchingData.append(code1).append("\n");
                                matchingData.append(credit1).append("\n");
                                matchingData.append(prereq11).append("\n");
                                matchingData.append(prereq21).append("\n");
                                matchingData.append(sec1).append("\n");
                                matchingData.append(day11).append("\n");
                                matchingData.append(day21).append("\n");
                                matchingData.append(t11).append("\n");
                                matchingData.append(t21).append("\n");
                                matchingData.append(dep1).append("\n\n");
                                System.out.println("Cname: " + cname1);
                                System.out.println("Code: " + code1);
                                System.out.println("Credit: " + credit1);
                                System.out.println("Prereq1: " + prereq11);
                                System.out.println("Prereq2: " + prereq21);
                                System.out.println("Section: " + sec1);
                                System.out.println("Day1: " + day11);
                                System.out.println("Day2: " + day21);
                                System.out.println("Time1: " + t11);
                                System.out.println("Time2: " + t21);
                                System.out.println("Department: " + dep1);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    fw.write(matchingData.toString());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // private boolean isCnameExists(String cname) {
    //     try (BufferedReader reader = new BufferedReader(new FileReader(file1))) {
    //         String line;
    //         while ((line = reader.readLine()) != null) {
    //             if (cname.equals(line)) {
    //                 return true; // cname already exists in all.txt
    //             }
    //             // Skip other lines
    //             reader.readLine(); // Skip lines like code, credit, prereq1, prereq2, etc.
    //         }
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    //     return false; // cname not found in all.txt
    // }

    public static void main(String[] args) {
        new comparedata();
        System.out.println("Program executed successfully!");
    }
}