import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class Design {
	String LatestDesign;
	String Content;
	String Type;
	public static final String list="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final int length=7;
	String array[]={"image","video","banner","audio","poster"};
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
	
	void modifyAd(){
		String req=scan.next();
		if(req!=null){
			req=scan.next();
			System.out.println("Changes will be done shortly");	
		}
		System.out.println("Are you satisfied?\n0 for no\n1 for yes");
		int i=scan.nextInt();
		if(i==0){
			Client c=new Client();
			c.suggestChanges();
		}
		else{
			System.out.println("Enter date");
			String date=scan.next();
			Connection cDB=getConnect();
			if(cDB!=null){
				Statement st=null;
				String sql="insert into advertising.listofads(adname,ownername,popularity,price,timestamps,publisher,type) values ('"+
							generateRandomString()+"','"+generateRandomString()+"',"+
							rand.nextInt(20)+","+rand.nextInt(20)*1000+",'"+date+"','"+generateRandomString()+"','"+array[i]+"');";
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
			Sales s=new Sales();
			s.publishing();
		}
	}
	
	void designing(){
		System.out.println("Designer will decide the ad shortly\n");
		int i=rand.nextInt(array.length);
		System.out.println("Design Ready");
		System.out.println(generateRandomString());
		System.out.println("Please press 1. to change\n2. to confirm");
		Scanner scan=new Scanner(System.in);
		int input=scan.nextInt();
		Client c=new Client();
		switch (input) {
		case 1:
			c.suggestChanges();
			break;
		case 2:
			System.out.println("Enter date");
			String date=scan.next();
			Connection cDB=getConnect();
			if(cDB!=null){
				Statement st=null;
				String sql="insert into advertising.listofads(adname,ownername,popularity,price,timestamps,publisher,type) values ('"+
							generateRandomString()+"','"+generateRandomString()+"',"+
							rand.nextInt(20)+","+rand.nextInt(20)*1000+",'"+date+"','"+generateRandomString()+"','"+array[i]+"');";
				try {
					st=cDB.createStatement();
					st.executeUpdate(sql);
					System.out.println("Proceeding to Sales");
					Sales s=new Sales();
					s.publishing();
				} 
				catch (Exception e) {
					e.printStackTrace();
					System.out.println("Try again!");
				}
			}
			break;
		default:
			break;
		}
		scan.close();
	}
	
	void contentWriting(){
		System.out.println("Write the content\n");
		
	}
	
	public String generateRandomString(){
        
        StringBuffer randStr = new StringBuffer();
        for(int i=0; i<length; i++){
            int number = getRandomNumber();
            char ch = list.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }
    
	private int getRandomNumber() {
        int randomInt = 0;
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(list.length());
        if (randomInt - 1 == -1) {
            return randomInt;
        } else {
            return randomInt - 1;
        }
    }
}
