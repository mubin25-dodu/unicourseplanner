import java.lang.*;

public class AIUBCoursePlanner{
	public static void main(String[] args){
		users us = new users();
		//login lg = new login(us);
		login lg = new login(us);
		lg.setVisible(true);
	}
}