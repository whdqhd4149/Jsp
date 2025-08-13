package dto;

public class User6DTO {
	
	private String name;
	private String gender;
	private int age;
	private String addr;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public void setAge(String age) {
		if(age != null) {
			this.age = Integer.parseInt(age);
		}
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	@Override
	public String toString() {
		return "User6DTO [name=" + name + ", gender=" + gender + ", age=" + age + ", addr=" + addr + "]";
	}
	
	

}
