import java.io.*;
import java.util.Scanner;

public class seperatecode {
    File file1 = new File("Files/all.txt");
    File file2 = new File("Files/coursedata.txt");
    File file3 = new File("Files/planner.txt");

    public  seperatecode(){
        try {
            File f = new File ("Files/all.txt");
            Scanner sc = new Scanner(f);

            while (sc.hasNext() ) {
                String l1 = sc.nextLine();
                String l2 = sc.nextLine();
                String l3 = sc.nextLine();
                String l4 = sc.nextLine();
                String l5 = sc.nextLine();
                String l6 = sc.nextLine();
                String l7 = sc.nextLine();
                String l8 = sc.nextLine();
                String l9 = sc.nextLine();
                String l0 = sc.nextLine();
                String l11 = sc.nextLine();

                try {
                    File f2 = new File ("Files/coursedata.txt");
                    Scanner s = new Scanner(f2);
                    FileWriter fw = new FileWriter("Files/planner.txt",true);
                    while (sc.hasNext() ) {
                        String l12 = s.nextLine();
                        String l13 = s.nextLine();
                        String l14=  s.nextLine();
                        String l15 = s.nextLine();
                        String l16 = s.nextLine();
                        String l17 = s.nextLine();
                        String l18 = s.nextLine();
                        String l19 = s.nextLine();
                        String l20 = s.nextLine();
                        String l21 = s.nextLine();
                        String l22 = s.nextLine();

                        if (l2 != null && !l2.equals(l13)){
                            fw.write(l1 + "\n" );
                            fw.write(l2 + "\n" );
                            fw.write(l3 + "\n" );
                            fw.write(l4 + "\n" );
                            fw.write(l5 + "\n" );
                            fw.write(l6 + "\n" );
                            fw.write(l7 + "\n" );
                            fw.write(l8 + "\n" );
                            fw.write(l9 + "\n" );
                            fw.write(l0 + "\n" );
                            fw.write(l11 + "\n" );
                         
                        }
                    }fw.close();
                } catch (Exception e) {
                    System.out.println("file nai vai nai");

                }
            }
        } catch (Exception e) {
            System.out.println("file nai vai nai");

        }
    }
    public static void main(String[] args) {
        new ceperatecode();
        System.out.println("file nai vai nai!");
    }
}