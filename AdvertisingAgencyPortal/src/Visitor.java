import java.sql.*;
public class Visitor {
	public static Connection getConnect(){
		Connection c=null;
		try {
			Class.forName("org.postgresql.Driver").newInstance();
			String url="jdbc:postgresql://localhost:5432/postgres?searchpath=advertising";
			c=DriverManager.getConnection(url,"postgres","sen");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return c;
	}
	void register(String Name,String email, String Username, String password,String confirmPassword,long contactNumber){
		if(!password.equals(confirmPassword)){
			System.out.println("password and confirmpassword did not match. Login failed\n");
			return;
		}
		else{
			Connection cDB=getConnect();
			if(cDB!=null){
				Statement st=null;
				String sql="INSERT INTO advertising.client (name, username, password, emailid, contactnumber) values('"+
						Name+"','"+Username+"','"+password+"','"+email+"',"+contactNumber+");";
				try {
					st=cDB.createStatement();
					st.executeUpdate(sql);
					System.out.println("Registeration Successful");
				} catch (Exception e) {
					//e.printStackTrace();
					System.out.println("Try again! Username exists");
				}
			}
			
		}
			
	}
	
	void readBlog(){
		System.out.println("I don't have time to write a blog");
	}
}
