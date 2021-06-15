
public class LoginBean {
	private String userName, password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isUserAdmin() {
		return(password.equals("admin"));
	}
	
	public boolean isUserStudent() {
		return(password.equals("student"));
	}
}
