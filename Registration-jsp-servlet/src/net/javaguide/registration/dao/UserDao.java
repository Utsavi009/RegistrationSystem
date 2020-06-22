package net.javaguide.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.javaguide.registration.model.User;

public class UserDao {
	
	public int registerUser(User user) throws ClassNotFoundException{
		String INSERT_USER_SQL = "insert into user_info" +
				"(id, first_name, last_name, username, password, address, contact )" +
				"(?,?,?,?,?,?,?);";
		int result = 0;
		
		Class.forName("com.mysql.jdbc.Driver");

		
		try (Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/user_info","root","root");
			PreparedStatement ps = conn.prepareStatement(INSERT_USER_SQL))
		{
					ps.setInt(1, 1);
					ps.setString(2, user.getFirstName());
					ps.setString(3, user.getLastName());
					ps.setString(4, user.getUserName());
					ps.setString(5, user.getPassword());
					ps.setString(6, user.getAddress());
					ps.setString(7, user.getContact());
					
					System.out.println(ps);
					
					result = ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
