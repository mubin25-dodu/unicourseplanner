import java.io.FileWriter;

public class depdatas {
    depdata coursedatas[] = new depdata[100000];
    public static int coursecount = 0;

    public depdatas (depdata d){
        coursedatas[coursecount]= d;
        String data =  "Name - "+d.getcname() + "\n";
        data += "Course Code - " + d.getccode() + "\n";
        data += "Credit - " + d.getcredit() +"\n";
        data +="Pre Pequsite  - " + d.getprereq1() +  "\n";
        data +="              - " + d.getprereq2() +  "\n";
        data += "Sec - " +d.getsname() +  "\n";
        data +=  "Day - " +d.getsday1() + "\n";
        data += "     - " + d.getsday2() +  "\n";
        data += "Time - "+ d.getctime1() + "\n" ;
        data += "     - " + d.getctime2() + "\n";
        data +=   d.getdepartment() +  "\n\n";
       
    
        try {
            String filename = "Files/coursedata.txt"; // Using  dep for the filename
            FileWriter F = new FileWriter(filename, true);
            F.write(data);
            F.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
}