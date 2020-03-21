package mainapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		System.out.println("1.REGISTER");
		System.out.println("2.LOGIN");
		int x;
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in)); 
		x=Integer.parseInt(br.readLine());
		
		RegisterPojo registerpojo =new RegisterPojo();
		RegisterDAO registerdao= new RegisterDAO();
		Loginpojo loginpojo = new Loginpojo();
		LoginDAO logindao= new LoginDAO();
		
		switch(x)
		{
		case 1 :
			System.out.println("ENTER THE FIRST NAME");
			String firstname=br.readLine();
			System.out.println("ENTER THE LAST NAME");
			String lastname=br.readLine();
			System.out.println("ENTER THE USER NAME");
			String username=br.readLine();
			System.out.println("ENTER THE PASSWORD");
			String password=br.readLine();
			System.out.println("ENTER THE EMAIL");
			String email=br.readLine();
			
			registerpojo.setFirstname(firstname);
			registerpojo.setLastname(lastname);
			registerpojo.setUsername(username);
			registerpojo.setPassword(password);
			registerpojo.setEmail(email);
			
			registerdao.addUser(registerpojo);
			
			break;
		case 2 : 
			System.out.println("ENTER THE USER NAME");
			String name=br.readLine();
			System.out.println("ENTER THE PASSWORD");
			String pass=br.readLine();
			
			loginpojo.setName(name);
			loginpojo.setPass(pass);
			
			if(logindao.validate(loginpojo)==true)
			{
				Luck luck =new Luck();
						luck.display();
			}
			else
				System.out.println("Invalid username/password");
			
			break;
		
		}
	}

}
