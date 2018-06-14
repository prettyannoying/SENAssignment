
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Authentication {
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
	boolean authenticate(String username, String password){
		Connection cDB=getConnect();
		if(cDB!=null){
			Statement st=null;
			String sql="select * from advertising.client where username=\'"+username+"\' and password=\'"+password+"\';";
			try {
				st=cDB.createStatement();
				ResultSet rs=st.executeQuery(sql);
				while(rs!= null && rs.next()){
					return true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

}
