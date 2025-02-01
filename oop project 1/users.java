import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.*;
import java.util.Scanner;

public class users {
    user userlist[] = new user[1000];
    public static int userCount = 0;

    public users() {
        // user u1 = new user("Abdullah Al Mubin", "23-50139-1", "mubin@project", "mubin9516@gmail.com",
        //         "Admin");
        // // userlist[userCount] = ;
        // // userCount++;
        try {
            File f = new File ("Files/userdata=money.txt");
            Scanner sc = new Scanner(f);
  
          while (sc.hasNext() ) {
              String l1 = sc.nextLine();
              String l2 = sc.nextLine();
              String l3 = sc.nextLine();
              String l4 = sc.nextLine();
              String l5 = sc.nextLine();
              String l6 = sc.nextLine();
  
              String Name = l1.substring(5);
              String ID = l2.substring(4);
              String Pas = l3.substring(5);
              String Contact = l4.substring(8);
              String DEP = l5.substring(4);
             
  
              System.out.println(Name);
              System.out.println(ID);
              System.out.println(Pas);
              System.out.println(Contact);
              System.out.println(DEP);
              
              user u = new user(Name, ID, Pas, Contact, DEP);
              userlist[userCount] = u; userCount++;
              System.out.println(userCount+"-----------------------------");
          
              
          }
          sc.close();
            
          } catch (Exception e) {
             System.out.println("file nai vai nai");
             return;
          }
  
  
      }


    public int userExists(String id) {
        int index = -1;
        for (int i = 0; i < userCount; i++) {
            user currentUser = userlist[i];
            if (currentUser != null && currentUser.getid().equals(id)) { // Check for null
                index = i;
                break;
            }
        }
        return index;
    }

    public user getuser(int index, String enteredPassword) {
        if (userlist[index].getpassword().equals(enteredPassword)) {
            return userlist[index];
        } else {
            return null;
        }

    }
    public void adduser(user u) {
        userlist[userCount] = u;
        userCount++;
        //add users 
        String data= "Name-"+u.getname() + "\n";
         data+= "sid-"+u.getid() + "\n";
         data+= "Pass-"+u.getpassword() + "\n";
         data+= "contact-"+u.getcontact() + "\n";
         data+= "dep-"+u.getdep() + "\n"+ "\n";
            try {
                FileWriter F= new FileWriter("Files/userdata=money.txt",true);
                F.write(data);
                F.close();
            } catch (Exception e) {
                
            }
    }
    public void updatePassword(String id, String name, String contact, String newPassword, String dep) {
        String fileName = "Files/userdata=money.txt";
        String tempFileName = "Files/temp_userdata=money.txt";
    
        try {
            File inputFile = new File(fileName);
            File tempFile = new File(tempFileName);
    
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
    
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("sid-" + id)) {
                    line = "Name-" + name + "\n" +
                            "sid-" + id + "\n" +
                            "Pass-" + newPassword + "\n" +
                            "contact-" + contact + "\n" +
                            "dep-" + dep + "\n\n";
                }
                writer.write(line + "\n");
            }
    
            writer.close();
            reader.close();
    
            // Delete the original file
            if (inputFile.delete()) {
                // Rename the new file to the filename the original file had.
                if (!tempFile.renameTo(inputFile)) {
                    System.out.println("Could not rename the file");
                }
            } else {
                System.out.println("Could not delete the original file");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // for forget pass part
    
        public int userExistspass( String contact){
        int index = -1;
        for (int i = 0; i < userCount; i++) {
            user currentUser = userlist[i];
            if (currentUser.getcontact().equals(contact)) { // Check for null
                index = i;
                break;
            }
        }
        return index;
    }

    public user getuserpass(int index,String name,  String id ,String contact, String dep) {
        if ( userlist[index].getid().equals(id) &&  userlist[index].getname().equals(name) &&  userlist[index].getcontact().equals(contact) &&  userlist[index].getdep().equals(dep)) {
            return userlist[index];
        } else {
            return null;
        }

    }
    // for signup ccheck

     public int userExistsignup(String contact) {
        int index = -1;
        for (int i = 0; i < userCount; i++) {
            user currentUser = userlist[i];
            if (currentUser != null && currentUser.getcontact().equals(contact)) { // Check for null
                index = i;
                break;
            }
        }
        return index;
    }
    public user getusersignup(int index, String dep) {
        if ( userlist[index].getdep().equals(dep)) {
            return userlist[index];
        } else {
            return null;
        }

    } public void deleteUserFile(String contact) {
        File userFile = new File("Files/" + contact + ".txt");

        if (userFile.exists()) {
            if (userFile.delete()) {
                System.out.println("File deleted successfully");
            } else {
                System.out.println("Failed to delete the file");
            }
        } else {
            System.out.println("File not found");
        }
    }

}