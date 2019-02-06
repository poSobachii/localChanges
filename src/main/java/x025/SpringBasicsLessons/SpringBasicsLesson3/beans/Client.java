package x025.SpringBasicsLessons.SpringBasicsLesson3.beans;

public class Client {

	private String id;

	private String fullName;

	private String age;

	public Client(String id, String fullName) {
		super();
		this.id = id;
		this.fullName = fullName;
	}

	public Client(String id, String fullName, String age) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.age=age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setAge(String age){
		this.age = age;
	}

	public String getAge(){
		return age;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
