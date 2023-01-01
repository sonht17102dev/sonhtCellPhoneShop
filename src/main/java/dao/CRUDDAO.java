package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import context.DBContext;
import model.Account;

public class CRUDDAO {
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public void deleteAccount(String usermail) {
		String sql = "delete from Account where user_mail = ?";
		try {
			connection = new DBContext().getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1, usermail);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Account getAccountByUserMail(String userMail) {
		String sql = "select * from Account where user_mail = ?";
		try {
			connection = new DBContext().getConnection();
			ps = connection.prepareStatement(sql);
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
	
	public void updateAccount(String name, String address, String phone, String userMail) {
		String sql = "update account set user_name = ?, user_address = ?, user_phone=?, user_mail=? where user_mail = ?";
		try {
			connection = new DBContext().getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, address);
			ps.setString(3, phone);
			ps.setString(4, userMail);
			ps.setString(5, userMail);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public static void main(String[] args) {
		CRUDDAO cruddao = new CRUDDAO();
		LoginDAO loginDAO = new LoginDAO();
		Account account = cruddao.getAccountByUserMail("duongdt@fpt.com.vn");
		System.out.println(account.toString());
	}
}
