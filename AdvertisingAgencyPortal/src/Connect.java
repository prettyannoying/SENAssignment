import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

 
public class Connect{
	public static Connection getConnect(){
		Connection c=null;
		try {
			Class.forName("org.postgresql.Driver").newInstance();
			String url="jdbc:postgresql://localhost:5432/postgres?searchpath=advertising";
			//String url2="jdbc:postgresql://localhost:5432/postgres?searchpath=kuchbhi";
			c=DriverManager.getConnection(url,"postgres","sen");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return c;
	}
	public static void main(String[] args){
		Connection cDB=getConnect();
		if(cDB!=null){
			Statement st=null;
			String sql="select * from advertising.client";
			String q="set search_path to advertising";
			try {
				st=cDB.createStatement();
				ResultSet rs=st.executeQuery(sql);
				while(rs!= null && rs.next()){
					String name=rs.getString("name");
					String username=rs.getString("username");
					String email=rs.getString("emailid");
					System.out.println(name+" "+username+" "+email);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("kuch to dikha de");
		}
		else{
			System.out.println(":'(");
		}
	}
}