import java.util.HashMap;
import java.util.LinkedList;

public class ReferenceMonitor {
	ObjectManager manage = new ObjectManager();
	HashMap<String, SecurityLevel> objects = new HashMap<String, SecurityLevel>();// has
																					// level
	HashMap<String, SecurityLevel> subjects = new HashMap<String, SecurityLevel>();// has
																					// level

	public void createNewObject(String name, SecurityLevel level) {

		objects.put(name.toLowerCase(), level);
		this.manage.createObject(name, 0);
	}

	public void createSubject(String name, SecurityLevel level) {
		subjects.put(name.toLowerCase(), level);
	}

	public int checkRead(String sub, String obj) {
		if (subjects.containsKey(sub) && objects.containsKey(obj)) {
			if (subjects.get(sub).compareGreat(objects.get(obj))) {
				return this.manage.executeRead(obj);
			}
		}
		return 0;
	}

	public boolean checkWrite(String sub, String obj, int value) {
		if (subjects.containsKey(sub) && objects.containsKey(obj)) {
			if (subjects.get(sub).compareLess(objects.get(obj))) {
				this.manage.executeWrite(obj, value);
				return true;
			}
		}
		return false;
	}

	public int getValue(String obj) {
		for (SecureObject check : this.manage.objects) {
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

		public void executeWrite(String write, int value) {
			for (SecureObject check : this.objects) {
				if (check.name.equalsIgnoreCase(write)) {
					check.updateObject(value);
				}
			}

		}
	}

}
