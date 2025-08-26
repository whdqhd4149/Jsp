package dto;

public class User5DTO {
	
	private String name;
	private String gender;
	private int age;
	private String addr;
	private int seq;
	
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
	
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public void setSeq(String seq) {
		if(seq != null) {
			this.seq = Integer.parseInt(seq);
		}
	}
	
	
	@Override
	public String toString() {
		return "User5DTO [name=" + name + ", gender=" + gender + ", age=" + age + ", addr=" + addr + "]";
	}
	
	

}
