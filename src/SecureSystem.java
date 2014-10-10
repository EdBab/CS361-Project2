import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;



public class SecureSystem {
	 ReferenceMonitor monitor;
	 ArrayList<SecureSubject> subjects;
	 //PrintWriter writer;
	
	 
	 public SecureSystem() throws FileNotFoundException, UnsupportedEncodingException{
		 this.monitor = new ReferenceMonitor();
		 this.subjects = new ArrayList<SecureSubject>();
		  //writer = new PrintWriter("log", "UTF-8");
		
	 }

	public void createSubject(String name, SecurityLevel level) {

		this.subjects.add(new SecureSubject(name, 0));
		this.monitor.createSubject(name, level);
	}

	public  void updateSubject(String name, int x) {
		for (SecureSubject check : subjects) {
			if (name.equalsIgnoreCase(check.name)) {
				check.setTemp(x);
			}
		}
	}

	public static boolean isNumeric(String str) {
		for (char c : str.toCharArray()) {
			if (!Character.isDigit(c))
				return false;
		}
		return true;
	}

	public ReferenceMonitor getReferenceMonitor() {
		return this.monitor;
	}
	
	
	/*public void printLog(char x){
		if(x == '1'){
			this.writer.println("CREATE HAL OBJ");
			writer.println("CREATE LYLE OBJ");
			writer.println("WRITE LYLE OBJ 1");
			writer.println("READ LYLE OBJ");
			writer.println("DESTROY LYLE OBJ");
			writer.println("RUN LYLE");
		}
		else if(x == '0'){
			writer.println("CREATE LYLE OBJ");
			writer.println("WRITE LYLE OBJ 1");
			writer.println("READ LYLE OBJ");
			writer.println("DESTROY LYLE OBJ");
			writer.println("RUN LYLE");
		}
	}*/


	/*public void printState() {
		System.out.println("The current state is: ");
		System.out.println("   LObj has value: "
				+ this.monitor.getValue("LObj"));
		System.out.println("   HObj has value: "
				+ this.monitor.getValue("HObj"));
		System.out.println("   Lyle has recently read: "
				+ this.getSubjectTemp("Lyle"));
		System.out.println("   Hal has recently read: "
				+ this.getSubjectTemp("Hal"));
	}*/

	public int getSubjectTemp(String name) {
		for (SecureSubject check : this.subjects) {
			if (check.name.equalsIgnoreCase(name)) {
				return check.readTemp;
			}
		}
		return 0;
	}

	

}
