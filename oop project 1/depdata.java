public class depdata {
    // JTextField cname, ccode, credit, prereq1, prereq2, sname, sday1, sday2, ctime1, ctime2;
    String cname;
    String ccode;
    String credit;
    String prereq1;
    String prereq2;
    String sname;
    String sday1;
    String sday2;
    String ctime1;
    String ctime2;
    String department;
    
public depdata(String cname,String ccode,String credit,String prereq1,String prereq2,String sname,String sday1,String sday2,String ctime1,String ctime2,String department){
    this.cname= cname;
    this.ccode=ccode;
    this.credit=credit;
    this.prereq1=prereq1;
    this.prereq2=prereq2;
    this.sname=sname;
    this.sday1=sday1;
    this.sday2=sday2;
    this.ctime1=ctime1;
    this.ctime2=ctime2;
    this.department= department;
    }

    public String getcname(){
        return cname;

    }
    public String getccode(){
 return ccode;
    }
    public String getcredit(){
 return credit;
    }
    public String getprereq1(){
 return prereq1;
    }
    public String getprereq2(){
 return prereq2;
    }
    public String getsname(){
 return sname;
    }
    public String getsday1(){
 return sday1;
    }
    public String getsday2(){
 return sday2;
    }
    public String getctime1(){
 return ctime1;
    }
    public String getctime2(){
 return ctime2;
    }
    public String getdepartment(){
 return department;
    }

}