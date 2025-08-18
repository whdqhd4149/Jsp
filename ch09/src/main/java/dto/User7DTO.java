package dto;

public class User7DTO {
	
	private String id;
	private String name;
	private int age;
	private String email;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

		
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "User7DTO [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + "]";
	}
	
	

}
