import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class SecureSystem {
	ReferenceMonitor monitor = new ReferenceMonitor();
	ArrayList<SecureSubject> subjects = new ArrayList<SecureSubject>();

	public void createSubject(String name, SecurityLevel level) {

		this.subjects.add(new SecureSubject(name, 0));
		monitor.createSubject(name, level);
	}

	public void updateSubject(String name, int x) {
		for (SecureSubject check : this.subjects) {
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

	public void printState() {
		System.out.println("The current state is: ");
		System.out.println("   LObj has value: "
				+ this.monitor.getValue("LObj"));
		System.out.println("   HObj has value: "
				+ this.monitor.getValue("HObj"));
		System.out.println("   Lyle has recently read: "
				+ this.getSubjectTemp("Lyle"));
		System.out.println("   Hal has recently read: "
				+ this.getSubjectTemp("Hal"));
	}

	public int getSubjectTemp(String name) {
		for (SecureSubject check : this.subjects) {
			if (check.name.equalsIgnoreCase(name)) {
				return check.readTemp;
			}
		}
		return 0;
	}

	public static void main(String[] args) throws FileNotFoundException {
		File instructions = new File("instructionList");

		SecureSystem sys = new SecureSystem();
		SecurityLevel low = SecurityLevel.LOW;
		SecurityLevel high = SecurityLevel.HIGH;
		sys.getReferenceMonitor().createNewObject("Lobj", low);
		sys.getReferenceMonitor().createNewObject("Hobj", high);
		sys.createSubject("Lyle", low);
		sys.createSubject("Hal", high);
		Scanner sc = new Scanner(instructions);
		while (sc.hasNext()) {// generate bad instructions for all else's
			String x = sc.nextLine();
			String[] line = x.split(" ");
			if (line.length == 3) {
				Instruction instruct = new Instruction(line[0], line[1],
						line[2]);
				if (instruct.isReadInstruction()) {
					sys.updateSubject(
							instruct.getInstructionSubjName(),
							sys.monitor.checkRead(
									instruct.getInstructionSubjName(),
									instruct.getInstructionObjName()));
					instruct.printInstruction();

				} else {
					Instruction.BAD_INSTRUCTION.printInstruction();
				}
			} else if (line.length == 4 && isNumeric(line[3])) {
				Instruction instruct = new Instruction(line[0], line[1],
						line[2], Integer.valueOf(line[3]));
				if (instruct.isWriteInstruction()) {

					sys.monitor.checkWrite(instruct.getInstructionSubjName(),
							instruct.getInstructionObjName(),
							instruct.getInstructionValue());
					instruct.printInstruction();

				} else {
					Instruction.BAD_INSTRUCTION.printInstruction();
				}

			} else {
				Instruction.BAD_INSTRUCTION.printInstruction();
			}
			sys.printState();

		}
		sc.close();

	}

}
