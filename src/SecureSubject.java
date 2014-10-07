public class SecureSubject {
	int readTemp;
	String name;

	SecureSubject(String name, int readTemp) {
		this.name = name;
		this.readTemp = readTemp;
	}
	public boolean equals(SecureSubject check){
		if(this.name.equalsIgnoreCase(check.name) && this.readTemp == check.readTemp ){
			return true;
		}
		return false;
	}
	public void setTemp(int x){
		this.readTemp = x;
	}
}
