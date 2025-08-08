package dto.college;

public class CourseDTO {
	
	private String stdNo;
	private String name;
	private String birth;
	private String major;
	
	public String getStdNo() {
		return stdNo;
	}
	public void setStdNo(String stdNo) {
		this.stdNo = stdNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	@Override
	public String toString() {
		return "CourseDTO [stdNo=" + stdNo + ", name=" + name + ", birth=" + birth + ", major=" + major + "]";
	}
	
	
	
	
	
	
	
}
