package model;

public class Account {
	private String usr, pwd;
	private int role;
	private String name, address, phoneString;

	public Account(String usr, String pwd, int role, String name, String address, String phoneString) {
		super();
		this.usr = usr;
		this.pwd = pwd;
		this.role = role;
		this.name = name;
		this.address = address;
		this.phoneString = phoneString;
		
	}

	public Account() {
	}
//	public Account(String usr, String pwd) {
//		this.usr = usr;
//		this.pwd = pwd;
//	}

	public String getUsr() {
		return usr;
	}

	public void setUsr(String usr) {
		this.usr = usr;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneString() {
		return phoneString;
	}

	public void setPhoneString(String phoneString) {
		this.phoneString = phoneString;
	}


	@Override
	public String toString() {
		return "Account [usr=" + usr + ", pwd=" + pwd + ", role=" + role + ", name=" + name + ", address=" + address
				+ ", phoneString=" + phoneString + ", check="+ "]";
	}
	public String validate() {
		String messageString = "";
		if(usr.trim().equals("")) {
			messageString += "Email can't be empty<br>";
		}
		if(pwd.trim().equals("")) {
			messageString += "Password can't be empty<br>";
		}
		if(!usr.trim().matches("\\b[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,4}\\b")) {
			messageString += "Invalid email address<br>";
		}
		
		if(pwd.length() < 8) {
			messageString += "Password must be at least 8 characters<br>";
		} else if (pwd.matches("\\w*\\s+\\w*")){
			messageString += "Password cannot contain space<br>";
		}
		if (name.trim().length() == 0) {
			messageString += "Name cannot be blank<br>";
		}

		if (address.trim().length() == 0) {
			messageString += "Address cannot be blank<br>";
		}

		if (phoneString.trim().length() == 0) {
			messageString += "phone cannot be blank<br>";
		}

		return messageString;
	}
}
