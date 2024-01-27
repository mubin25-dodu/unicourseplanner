import java.io.*;

public class ceperatecode {
    File file1 = new File("Files/all.txt");
    File file2 = new File("Files/coursedata.txt");
    File file3 = new File("Files/planner-temp.txt");

    public ceperatecode() {
        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1));
             FileWriter fw = new FileWriter(file3, true)) {

            String line1;
   
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

                if (code != null && isCodeExistsInAll(code)) {

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
                           
                                try (BufferedReader reader3 = new BufferedReader(new FileReader(file3))) {
                                    String line3;
                                    while ((line3 = reader3.readLine()) != null) {
                                        String cname2 = line3;
                                        String code2 = reader3.readLine();
                                        String credit2 = reader3.readLine();
                                        String prereq12 = reader3.readLine();
                                        String prereq22 = reader3.readLine();
                                        String sec2 = reader3.readLine();
                                        String day12 = reader3.readLine();
                                        String day22 = reader3.readLine();
                                        String t12 = reader3.readLine();
                                        String t22 = reader3.readLine();
                                        String dep2 = reader3.readLine();

                                        if (code2.equals(code)) {

                                            continue;
                                        }

                                        matchingData.append(cname2).append("\n");
                                        matchingData.append(code2).append("\n");
                                        matchingData.append(credit2).append("\n");
                                        matchingData.append(prereq12).append("\n");
                                        matchingData.append(prereq22).append("\n");
                                        matchingData.append(sec2).append("\n");
                                        matchingData.append(day12).append("\n");
                                        matchingData.append(day22).append("\n");
                                        matchingData.append(t12).append("\n");
                                        matchingData.append(t22).append("\n");
                                        matchingData.append(dep2).append("\n\n");

                                        
                                        System.out.println("Cname: " + cname2);
                                        System.out.println("Code: " + code2);
                                        System.out.println("Credit: " + credit2);
                                        System.out.println("Prereq1: " + prereq12);
                                        System.out.println("Prereq2: " + prereq22);
                                        System.out.println("Section: " + sec2);
                                        System.out.println("Day1: " + day12);
                                        System.out.println("Day2: " + day22);
                                        System.out.println("Time1: " + t12);
                                        System.out.println("Time2: " + t22);
                                        System.out.println("Department: " + dep2);
                                    }
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
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

    private boolean isCodeExistsInAll(String code) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file1))) {
            String line;
            while ((line = reader.readLine()) != null) {
               
                if (code.equals(reader.readLine())) {
                    return true; 
                }
               
                reader.readLine(); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; 
    }

    public static void main(String[] args) {
        new ceperatecode();
        System.out.println("Program executed successfully!");
    }
}