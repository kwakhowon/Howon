package dto;

public class TestUser {
	
	private String id;
	private String password;
	private String email;
	private String dates;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDates() {
		return dates;
	}
	public void setDates(String dates) {
		this.dates = dates;
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", password=" + password + ", email=" + email + ", dates=" + dates + "]";
	}
	
}
