import java.io.FileWriter;

public class depdatas {
    depdata coursedatas[] = new depdata[100000];
    public static int coursecount = 0;

    public depdatas (depdata d){
        coursedatas[coursecount]= d;
       
        String data = "name-" + d.getcname() + "\n";
        data +="code-" +  d.getccode() + "\n";
        data += "credit-" + d.getcredit() + "\n";
        data += "prereq1-" +d.getprereq1() +  "\n";
        data += "prereq2-" + d.getprereq2() +  "\n";
        data += "sec-" +d.getsname() + "\n";
        data +=  "day1-" +d.getsday1() +"\n";
        data +=  "day2-" + d.getsday2() + "\n";
        data +=  "time1-" + d.getctime1() + "\n" ;
        data += "time2-" + d.getctime2() +"\n";
        data +=  "dep-" + d.getdepartment() +  "\n" +  "\n";
       
    
        try {
            String filename = "Files/coursedata.txt"; 
            FileWriter F = new FileWriter(filename, true);
            F.write(data);
            F.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
}