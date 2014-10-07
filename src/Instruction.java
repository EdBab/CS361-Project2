


public class Instruction {
	

	    // An instruction can have one of the following forms:
	    //    READ subj obj 
	    //    WRITE subj obj value
	    // Anything else is considered to be a bad instruction 
	    // and is rejected. 

	    // LOCAL FIELDS:

	    String command, subjName, objName;
	    int value;


	    // CONSTRUCTORS AND CONSTANTS:

	    public Instruction(String com, String subj, String obj) {
		command = com;
		subjName = subj.toLowerCase();
		objName = obj.toLowerCase();
	    } // Instruction

	    public Instruction(String com, String subj, String obj, int val) {
		command = com;
		subjName = subj.toLowerCase();
		objName = obj.toLowerCase();
		value = val;
	    } // Instruction

	    static final Instruction BAD_INSTRUCTION
		// This is used as the representation of any illegal instruction in 
		// the instruction stream.
		= new Instruction("BadInstruction", "NoSubject", "NoObject");


	    // ACCESSORS:

	    public boolean isReadInstruction () {
		return (command.equalsIgnoreCase("Read"));
	    } // isReadInstruction

	    public boolean isWriteInstruction () {
		return (command.equalsIgnoreCase("Write"));
	    } // isReadInstruction
	    public boolean isValidSubject(ReferenceMonitor mon){
	    	if(mon.subjects.containsKey(subjName)){
	    		return true;
	    	}
	    	return false;
	    }
	    public boolean isValidObject(ReferenceMonitor mon){
	    	if(mon.objects.containsKey(objName)){
	    		return true;
	    	}
	    	return false;
	    }

	    public String getInstructionCommand () {
		return command;
	    } // getInstructionCommand

	    public String getInstructionObjName () {
		return objName.toLowerCase();
	    } // getInstructionObjName

	    public String getInstructionSubjName () {
		return subjName.toLowerCase();
	    } // getInstructionSubjName

	    public int getInstructionValue () {
		// This will only be valid for a WRITE
		return value;
	    } // getInstructionValue


	    // OTHER FUNCTIONS:

	    public static Instruction parseInstruction (String line) {
			return null;
	       
	    } // parseInstruction
		

	    public void printInstruction () {
	        if(command.equals("BadInstruction")){
	        	System.out.println(command);
	        }
	        else if(command.equalsIgnoreCase("read")){
	        	System.out.println(subjName + " reads " + objName);
	        }
	        else
	        {
	        	System.out.println(subjName + " writes value " + value + " to " + objName);
	        }
	    } // printInstruction
}
