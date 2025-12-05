package learn_comparator;

public class Student {
	int regNum;
	String name;
	int age;
	
	public Student(int regNum, String name, int age ) {
		this.regNum = regNum;
		this.name = name ;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Student " + regNum + " name " + name+" age "+age;
	}
	
//	 We decide that two students are the SAME if they have the same regNum.
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		
		if( obj==null || getClass() != obj.getClass());
		
		Student student = (Student) obj;
		return this.regNum == student.regNum;
	}
	
	@Override
	public int hashCode() {
		
		return Integer.hashCode(regNum);
	}
}
