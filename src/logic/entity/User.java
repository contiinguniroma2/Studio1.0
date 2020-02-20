package logic.entity;

public class User {
	protected String name;
	protected String userName;
	protected String mail;
	protected String password;
	protected String phone;

	public String getName() {
		return name;
	}

	public void setNome(String nome) {
		this.name = nome;
	}

	public String getUsername() {
		return userName;
	}

	public void setUsername(String username) {
		this.userName = username;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void fillUser(String username, String mail, String password, String name, String phone) {
		this.name = name;
		this.userName = username;
		this.mail = mail;
		this.password = password;
		this.phone = phone;
	}

}
