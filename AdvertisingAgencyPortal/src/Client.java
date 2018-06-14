import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
public class Client extends Visitor{
	String Name;
	String UserName;
	String ServicesTaken;
	Scanner scan=new Scanner(System.in);
	Random rand=new Random();
	
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
	
	void designingAd(){
		System.out.println("Design ad mode\n");
		System.out.println("Do you want to design on 1. your own or 2. ask a designer?");
		Scanner scan=new Scanner(System.in);
		int input=scan.nextInt();
		switch (input) {
		case 1:
			System.out.println("Enter adname, ownername, popularity, price, timestamps, publisher, type");
			String adname=scan.next();
			String ownername=scan.next();
			int popularity=rand.nextInt(15);
			int price=rand.nextInt(20)*1000;
			String date=scan.next();
			String publisher=scan.next();
			String type=scan.next();
			Connection cDB=getConnect();
			if(cDB!=null){
				Statement st=null;
				String sql="insert into advertising.listofads(adname,ownername,popularity,price,timestamps,publisher,type) values ('"+
							adname+"','"+ownername+"',"+
							popularity+","+price+",'"+date+"','"+publisher+"','"+type+"');";
				try {
					st=cDB.createStatement();
					st.executeUpdate(sql);
					System.out.println("Proceeding to Sales");
					Sales s=new Sales();
					s.preMarketAnalysis();
				} 
				catch (Exception e) {
					e.printStackTrace();
					System.out.println("Try again!");
				}
			}
			break;
		case 2:
			Design d=new Design();
			d.designing();
			break;

		default:
			break;
		}
		scan.close();
	}
	
	void modifyAd(){
		System.out.println("Modify the finalised ad mode\n");
		int id=scan.nextInt();
		System.out.println("Enter name of attribute to change");
		String att=scan.next();
		System.out.println("Enter the modification");
		String modify=scan.next();
		Connection cDB=getConnect();
		if(cDB!=null){
			Statement st=null;
			String sql="update advertising.listofads set "+att+"='"+modify+"' where id="+id;
			try {
				st=cDB.createStatement();
				st.executeUpdate(sql);
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Modification done");
		}
	}

	void deleteAd(){
		System.out.println("Enter the id of the ad you want to delete");
		int i=scan.nextInt();
		String sql="delete from advertising.listofads where id="+i+";";
		Connection cDB=getConnect();
		try {
			Statement st=cDB.createStatement();
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Deleted!");
	}
	
	void suggestChanges(){
		System.out.println("Please enter your requirements\n");
		Design d=new Design();
		d.modifyAd();
	}
	
	void editUserProfile(){
		System.out.println("Enter username and password");
		String username=scan.next();
		String password=scan.next();
		Connection cDB=getConnect();
		if(cDB!=null){
			Statement st=null;
			String sql="select * from advertising.client where username=\'"+username+"\' and password=\'"+password+"\';";
			try {
				st=cDB.createStatement();
				ResultSet rs=st.executeQuery(sql);
				while(rs!= null && rs.next()){
					
				}
				System.out.println("Enter the detail you want to edit");
			}
			catch (Exception e) {
				//e.printStackTrace();
				System.out.println("Incorrect! Try again!");
			}
			String s=scan.next();
			System.out.println("Enter the modification");
			String s1=scan.next();
			cDB=getConnect();
			if(cDB!=null){
				st=null;
				sql="update advertising.client set "+s+"='"+s1+"' where username='"+username+"';";
				try {
					st=cDB.createStatement();
					st.executeUpdate(sql);
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("Your settings have been updated :)");
			}
		}
		
	}
	
	
}
