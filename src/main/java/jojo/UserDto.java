package jojo;

public class UserDto {
	
	private int usid;
	private String name;
	private String password;

	public UserDto(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	public int getUsid() {
		return usid;
	}
	public void setUsid(int usid) {
		this.usid = usid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
