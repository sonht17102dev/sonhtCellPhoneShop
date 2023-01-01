package dao;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import context.DBContext;
import model.Cart;
import model.CartDetails;
import model.Orders;
import model.Product;

public class OrdersDAO {

	// insert information of Order to data source, that including list of
	// products in cart (c) and information of buyer in Orders (o)
	public void insertOrder(Orders o, Cart c) throws Exception {
		Connection connection = new DBContext().getConnection();
		try {
			String queryOrderDetail = "insert into orders_detail values (?,?,?,?)";
			List<CartDetails> products = c.getItems();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select top 1 order_id from orders_detail order by order_id desc");
			int id = 0;
			if(rs.next()) {
				id = rs.getInt("order_id");
			}
			id += 1;
			
			String queryOrder = "set identity_insert orders on\n"
					+ "insert into orders (user_mail, order_id, order_status, order_date, order_discount_code, order_address)\n"
					+ "values (?,?,?,?,?,?)\n"
					+ "set identity_insert orders off";
			PreparedStatement statement2 = connection.prepareStatement(queryOrder);
		
			statement2.setString(1, o.getUserMail());
			statement2.setString(2, "" + id);
			statement2.setString(3, "" + o.getStatus());
			Date date = new Date(Calendar.getInstance().getTime().getTime());
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String validDate = df.format(date);
			 
			statement2.setString(4, validDate);
			statement2.setString(5, o.getDiscount());
			statement2.setString(6, o.getAddress());

			statement2.executeUpdate();
			statement2.close();
			
			PreparedStatement statement3 = connection.prepareStatement(queryOrderDetail);
			
			for (CartDetails cd : products) {
				statement3.setString(1, "" + id);
				statement3.setString(2, "" + cd.getProduct().getId());
				statement3.setString(3, "" + cd.getQuantity() * cd.getProduct().getPrice());
				statement3.setFloat(4, (float) cd.getProduct().getPrice());
				statement3.executeUpdate();
			}
			statement3.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
