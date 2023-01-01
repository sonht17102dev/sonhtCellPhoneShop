package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Account;

public class LoginDAO {
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public Account checkLogin(String user, String pass) {
		try {
			String query = "select * from Account where user_mail = ? and password = ?";
			connection = new DBContext().getConnection();
			ps = connection.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			
			while (rs.next()) { // lay du lieu tu Result Sqlserver
				Account account = new Account(
						rs.getString(1),
						rs.getString(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6)
						);
				
				return account;
			}
			
			rs.close();
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return new Account();
	}
	
	public Account checkLoginExist(String userMail) {
		try {
			String query = "select * from Account where user_mail = ?";
			connection = new DBContext().getConnection();
			ps = connection.prepareStatement(query);
			ps.setString(1, userMail);
			
			rs = ps.executeQuery();
			
			while (rs.next()) { // lay du lieu tu Result Sqlserver
				Account account = new Account(
						rs.getString(1),
						rs.getString(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6)
						);
				
				return account;
			}
			
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Account> getAllAccount () {
		List<Account> list = new ArrayList<>();
		try {
			String query = "select * from Account";
			connection = new DBContext().getConnection();
			ps = connection.prepareStatement(query);
			
			rs = ps.executeQuery();
			
			while (rs.next()) { // lay du lieu tu Result Sqlserver
				list.add(new Account(
						rs.getString(1),
						rs.getString(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6)
						));
				
				
			}
			rs.close();
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public void signup(String userMail, String pass, String userName, String address, String phone) {
		String query = "insert into Account\r\n"
				+ "values (?,?,1,?,?, ?)";
		try {
			connection = new DBContext().getConnection();
			ps = connection.prepareStatement(query);
			ps.setString(1, userMail);
			ps.setString(2, pass);
			ps.setString(3, userName);
			ps.setString(4, address);
			ps.setString(5, phone);
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void createAdmin(String userMail, String pass, String userName, String address, String phone) {
		String query = "insert into Account\r\n"
				+ "values (?,?,0,?,?, ?)";
		try {
			connection = new DBContext().getConnection();
			ps = connection.prepareStatement(query);
			ps.setString(1, userMail);
			ps.setString(2, pass);
			ps.setString(3, userName);
			ps.setString(4, address);
			ps.setString(5, phone);
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		LoginDAO dao = new LoginDAO();
		List<Account> list = dao.getAllAccount();
		for (Account account : list) {
			System.out.println(account.getName() + ", " + account.getRole());
		}
	}
}
