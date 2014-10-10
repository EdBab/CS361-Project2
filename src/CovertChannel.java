import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class CovertChannel {
	
	SecureSystem sys;
	static boolean vflag;
	static PrintWriter logWriter;
	static PrintWriter outWriter;

	public CovertChannel(boolean flag) throws FileNotFoundException, UnsupportedEncodingException {
		vflag = flag;
		this.sys = new SecureSystem();
		logWriter = new PrintWriter("log", "UTF-8");
		outWriter = new PrintWriter("test.out", "UTF-8");
	}

	public void sendBit(char x) throws FileNotFoundException, UnsupportedEncodingException {
		
		sys.createSubject("Lyle", SecurityLevel.LOW);
		sys.createSubject("Hal", SecurityLevel.HIGH);
		if (x == '0') {

			this.sys.getReferenceMonitor().createNewObject("Obj",
					SecurityLevel.HIGH);
			sys.getReferenceMonitor().createNewObject("Obj", SecurityLevel.LOW);
			sys.getReferenceMonitor().checkWrite("lyle", "Obj", 1);
			sys.updateSubject("lyle",
					sys.getReferenceMonitor().checkRead("lyle", "Obj"));
			sys.getReferenceMonitor().checkDestroy("Lyle", "Obj");

			SecureSubject.run(sys.subjects.get(1).getTemp());
			if (vflag) {
				logWriter.println("CREATE HAL OBJ");
				logWriter.println("CREATE LYLE OBJ");
				logWriter.println("WRITE LYLE OBJ 1");
				logWriter.println("READ LYLE OBJ");
				logWriter.println("DESTROY LYLE OBJ");
				logWriter.println("RUN LYLE");
			}

		} else if (x == '1') {
			sys.getReferenceMonitor().createNewObject("Obj", SecurityLevel.LOW);
			sys.getReferenceMonitor().checkWrite("Lyle", "Obj", 1);
			sys.updateSubject("Lyle",
					sys.getReferenceMonitor().checkRead("Lyle", "Obj"));
			sys.getReferenceMonitor().checkDestroy("Lyle", "Obj");

			SecureSubject.run(sys.subjects.get(0).getTemp());
			if (vflag) {
				logWriter.println("CREATE LYLE OBJ");
				logWriter.println("WRITE LYLE OBJ 1");
				logWriter.println("READ LYLE OBJ");
				logWriter.println("DESTROY LYLE OBJ");
				logWriter.println("RUN LYLE");
			}

		} else
			System.err.println("messed up sendBit");
		
	}

	
	//takes an 8 bit string, sends a digit at a time
	public void charAsByte(String x) throws FileNotFoundException, UnsupportedEncodingException  {
		if (x.length() < 8) {

			String add = "";
			int c = x.length();
			while (c < 8) {
				add += "0";
				c++;

			}
			x = add + x;
		}

		for (int i = 0; i < x.length(); i++) {
			sendBit(x.charAt(i));
			
			}
		}
	
	
	public static void printChar(char x){
		outWriter.print(x);
	}

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		File test = new File("test");
		// sys.getReferenceMonitor().createNewObject("Lobj", low);
		// sys.getReferenceMonitor().createNewObject("Hobj", high);
		/*if (args[0].equals("v")) {
			CovertChannel chan = new CovertChannel(true);
			
		
		
	}*/
		
		
		
		CovertChannel chan = new CovertChannel(true);
		chan.sys.getReferenceMonitor()
				.createNewObject("Obj", SecurityLevel.LOW);
		Scanner sc = new Scanner(test);
		
		
		while (sc.hasNext()) {
			String x = sc.nextLine();

			for (int i = 0; i < x.length(); i++) {

				Integer send = (Integer) (int) x.charAt(i);

				chan.charAsByte(Integer.toBinaryString(send));
			}
			outWriter.println("");
		}
		sc.close();
		logWriter.close();
		outWriter.close();
	}
	
}
