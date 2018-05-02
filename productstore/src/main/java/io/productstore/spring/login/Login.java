package io.productstore.spring.login;

public class Login {

	private String username,password;

	/**
	 * @param username
	 * @param password
	 */
	public Login(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}



	public Login() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
