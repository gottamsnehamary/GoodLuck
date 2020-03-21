package mainapp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO {

	public boolean validate(Loginpojo loginpojo) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String name=loginpojo.getName();
		String pass=loginpojo.getPass();
		
		ConnectionManager con= new ConnectionManager();
		Statement st= con.getConnection().createStatement();
		
		ResultSet rs = st.executeQuery("SELECT * FROM UDETAILS");
		
		while(rs.next())
			if(name.equals(rs.getString("USERNAME"))&&(pass.equals(rs.getString("PASSWORD"))))
					{
				con.getConnection().close();
				return true;
					}
			
			else
			{
				con.getConnection().close();
				return false;
			}
			
			
		return false;
		
	}

	
}
