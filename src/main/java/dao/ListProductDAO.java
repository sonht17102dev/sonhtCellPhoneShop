package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Product;
import model.ProductOrders;

public class ListProductDAO {
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	// return the list of products by product name
	public List<Product> searchByName(String txtSearch) throws Exception {
		List<Product> list = new ArrayList<>();
		String query = "select * from Products where product_name like ?";
		try {
			connection = new DBContext().getConnection();
			ps = connection.prepareStatement(query);
			ps.setString(1, "%"+txtSearch+"%");
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getFloat(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7)
						));
			}
			rs.close();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Product> getAllProducts() throws Exception {
		List<Product> list = new ArrayList<>();
		String query = "select * from Products";
		try {
			connection = new DBContext().getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getFloat(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7)
						));
			}
			rs.close();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public List<Product> getTop6Products() throws Exception {
		List<Product> list = new ArrayList<>();
		String query = "select top 6 * from Products";
		try {
			connection = new DBContext().getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getFloat(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7)
						));
			}
			rs.close();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	// get 1 product
	public Product getProduct(int id) throws Exception {
		String query = "select * from products where product_id = ?";
		try {
			connection = new DBContext().getConnection();
			ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Product(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getFloat(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7)
						);
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public Product getProductOrdersByID (int id) {
		String query = "select * from products where product_id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				return new Product(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getFloat(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getInt(8)
						);
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public List<Product> pagingProducts (int index) {
		List<Product> list = new ArrayList<>();
		String queryString = "select * from Products\r\n"
				+ "order by product_id\r\n"
				+ "OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY";
		try {
			connection = new DBContext().getConnection();
			ps = connection.prepareStatement(queryString);
			ps.setInt(1, (index - 1)*6);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Product(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getFloat(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7)
						));
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	public int getTotalProduct() {
		String query = "select count(*) from products";
		try {
			connection = new DBContext().getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}
	public static void main(String[] args) throws Exception {
		List<Product> list = new ListProductDAO().getTop6Products();
		for (Product product : list) {
			System.out.println(product.toString());
		}
	}
}
