import java.lang.*;

public class user {
    String id;
    String name;
    String contact;
    String Password;
    String dep;

    public user(String name, String id, String Password, String contact, String dep) {
        this.name = name;
        this.id = id;
        this.contact = contact;
        this.Password = Password;
        this.dep = dep;
    }

    public user() {
    }
    public void setname(String name){
		this.name = name;
	}
	public void setPassword(String password){
		this.Password = password;
	}
	public void setid(String id){
		this.id = id;
	}
	public void setcontact(String contact){
		this.contact = contact;
	}
	public void setdep(String dep){
		this.dep = dep;
	}
	

    public String getname() {
        return name;

    }

    public String getpassword() {
        return Password;
    }

    public String getid() {
        return id;

    }

    public String getcontact() {
        return contact;
    }

    public String getdep() {
        return dep;

    } 

}
