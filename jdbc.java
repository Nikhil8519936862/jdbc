package jdbcconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc
{


	public static void main(String[] args) throws Exception 
	{
		String query = "select * from actor";



		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "Nikhilraj@1");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			String userData="";
			
			while(rs.next())
			{
				userData = rs.getInt(1)+ " : " + rs.getString(2);
				System.out.println(userData);
			}

			st.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

}





