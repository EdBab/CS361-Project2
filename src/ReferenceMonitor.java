import java.util.HashMap;
import java.util.LinkedList;


public class ReferenceMonitor {
	ObjectManager manage = new ObjectManager();
	 HashMap<String, SecurityLevel> objects = new HashMap<String,SecurityLevel>();// has level
	 HashMap<String, SecurityLevel> subjects = new HashMap<String,SecurityLevel>();// has level

	public void createNewObject(String name, SecurityLevel level) {
		
		this.objects.put(name.toLowerCase(), level);
		this.manage.createObject(name, 0);
	}

	public void createSubject(String name, SecurityLevel level) {
		
		this.subjects.put(name.toLowerCase(), level);
	}

	public int checkRead(String sub, String obj) {
		sub =  sub.toLowerCase();
		obj = obj.toLowerCase();
		if (this.subjects.get(sub).compareGreat(this.objects.get(obj))) {
			return this.manage.executeRead(obj);
		}
		return 0;
	}
	
	public void checkDestroy(String sub, String obj) {
		if (this.subjects.containsKey(sub.toLowerCase())
				&& this.objects.containsKey(obj.toLowerCase())) {
			if (this.subjects.get(sub.toLowerCase()).compareLess(
					this.objects.get(obj.toLowerCase()))) {
				
				this.objects.remove(obj);
				this.manage.executeDestroy(obj.toLowerCase());
			}
		}
	}
	

	public boolean checkWrite(String sub, String obj, int value) {

		sub =  sub.toLowerCase();
		obj = obj.toLowerCase();
	
		if (this.subjects.get(sub).compareLess(this.objects.get(obj))) {
	
			this.manage.executeWrite(obj, value);
			return true;
		}
		return false;
	}
	
	/*public int getValue(String obj){
		for(SecureObject check : this.manage.objects){
			if(check.name.equalsIgnoreCase(obj)){
				return check.value;
			}
		}
		return 0;
	}*/

	class ObjectManager {
		HashMap<String,Integer>objects = new HashMap<String,Integer>();;// has value

		public void createObject(String add, int value) {
			
			add = add.toLowerCase();
		
			//this.objects.add(new SecureObject(add, value));
			this.objects.put(add, value);
		}
		
		public void executeDestroy(String obj) {
			
			this.objects.remove(obj);
			/*for (SecureObject check : this.objects) {
				if (check.name.equalsIgnoreCase(obj)) {
					this.objects.remove(check);
				}
			}*/
		}

		public int executeRead(String obj) {
			return this.objects.get(obj);
			/*for (SecureObject check : this.objects) {
				if (check.name.equalsIgnoreCase(obj)) {
					
					return check.value;
				}
			}*/

			//return 0;
		}

		public void executeWrite(String write, int value) {
			/*for (SecureObject check : this.objects) {
				if (check.name.equalsIgnoreCase(write)) {
					check.updateObject(value);
				}
			}*/
			this.objects.put(write, value);
		}
	}

}



/*import java.util.HashMap;
import java.util.LinkedList;

public class ReferenceMonitor {
	 ObjectManager manage;// just for this project
	 HashMap<String, SecurityLevel> objects = new HashMap<String, SecurityLevel>();// just
																							// for
																							// this
																							// program

	static HashMap<String, SecurityLevel> subjects = new HashMap<String, SecurityLevel>();// for
																							// prog

	public void createNewObject(String name, SecurityLevel level) {
		if (!objects.containsKey(name.toLowerCase())) {
			objects.put(name.toLowerCase(), level);
			System.out.println("herro " + name);
			this.manage.createObject(name, 0);
			
		}
	}

	public void createSubject(String name, SecurityLevel level) {
		subjects.put(name.toLowerCase(), level);
	}

	public  int checkRead(String sub, String obj) {
		if (subjects.containsKey(sub.toLowerCase())
				&& objects.containsKey(obj.toLowerCase())) {
			if (subjects.get(sub.toLowerCase()).compareGreat(
					objects.get(obj.toLowerCase()))) {
				return manage.executeRead(obj);
			}
		}
		return 0;
	}

	public boolean checkWrite(String sub, String obj, int value) {
		if (subjects.containsKey(sub.toLowerCase())
				&& objects.containsKey(obj.toLowerCase())) {
			if (subjects.get(sub.toLowerCase()).compareLess(
					objects.get(obj.toLowerCase()))) {
				manage.executeWrite(obj.toLowerCase(), value);
				return true;
			}
		}
		return false;
	}

	public void checkDestroy(String sub, String obj) {
		if (subjects.containsKey(sub.toLowerCase())
				&& objects.containsKey(obj.toLowerCase())) {
			if (subjects.get(sub.toLowerCase()).compareLess(
					objects.get(obj.toLowerCase()))) {
				System.out.println("(yo()");
				objects.remove(obj);
				manage.executeDestroy(obj.toLowerCase());
			}
		}
	}

	public int getValue(String obj) {
		for (SecureObject check : manage.objects) {
			if (check.name.equalsIgnoreCase(obj)) {
				return check.value;
			}
		}
		return 0;
	}

	class ObjectManager {
		LinkedList<SecureObject> objects = new LinkedList<SecureObject>();// has
																			// value

		public void createObject(String add, int value) {
			System.out.println("fdjkf");
			this.objects.add(new SecureObject(add, value));

		}

		public int executeRead(String obj) {
			for (SecureObject check : this.objects) {
				if (check.name.equalsIgnoreCase(obj)) {

					return check.value;
				}
			}

			return 0;
		}

		public void executeDestroy(String obj) {

			for (SecureObject check : this.objects) {
				if (check.name.equalsIgnoreCase(obj)) {
					this.objects.remove(check);
				}
			}
		}

		public void executeWrite(String write, int value) {
			for (SecureObject check : this.objects) {
				if (check.name.equalsIgnoreCase(write)) {
					check.updateObject(value);
				}
			}

		}
	}

}*/
