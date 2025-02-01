public class student {
    	String student;
	String studentname;
	String emailtf;

	
	public student (String student, String studentname, String emailtf){
		this.student = student;
		this.studentname = studentname;
		this.emailtf = emailtf;
		
	}
	
	public String getName(){
		return student;
	}
	public String getPassword(){
		return studentname;
	}
	public String getGender(){
		return emailtf;
	}

}