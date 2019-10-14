import java.util.*;
import java.sql.*;
import java.util.Date;
import java.util.Collections;
import java.util.ArrayList;

	public class Advertisement {
		public static ArrayList<lastest> AdList=new ArrayList<lastest>();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MMM-yyyy");
	 
		public static Connection getConnect(){
			Connection c=null;
			try {
				Class.forName("org.postgresql.Driver").newInstance();
				String url="jdbc:postgresql://localhost:5432/postgres?searchpath=advertising";
				c=DriverManager.getConnection(url,"postgres","sen");
			} 
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return c;
		}
		
		private static lastest b1; 
		 static Scanner sc= new Scanner(System.in);
		 void iNeedThisMethod(){
		  Connection cDB=getConnect();
		  if(cDB!=null){
		   Statement st=null;
		   String sql="select * from advertising.listofads";
		   try {
		    st=cDB.createStatement();
		    ResultSet rs=st.executeQuery(sql);
		    while(rs!= null && rs.next())
		    {
		    	int id=rs.getInt("id"); 
		    	String adname=rs.getString("adname");
		    	String ownername=rs.getString("ownername");
		    	String publisher=rs.getString("publisher");
		    	String type=rs.getString("type");
		    	int price=rs.getInt("price"); 
		    	Date date=rs.getDate("timestamps");
		    	int popularity=rs.getInt("popularity");
		        lastest b1=new lastest(id,adname,ownername,publisher,type,price,date,popularity); 
		        AdList.add(b1);
		    }
		    System.out.println("Hello! What are looking for?");
		    System.out.println("Choose any of the below options by entering the corresponding number");
		    System.out.println("1 for Search Ads");
		    System.out.println("2 for Sort and display Ads");
		    System.out.println("3 for filter and display Ads");
		    int n = sc.nextInt();
		    if(n==1)
		    	searchAds();
		    else if(n==2)
		    	sortAds();
		    else if(n==3)
		     filterAds();
		    else
		     System.out.println("Enter the appropiate number");
		    }
		   catch (Exception e)
		   {
		    e.printStackTrace();
		   }
		  }
		  else{
		   System.out.println(":'(");
		  }
		 }  
	
	static void sortAds(){
		System.out.println("Enter the parameter for sorting\n1.lowtohigh \n 2.hightolow 3.New\n 4.Popularity\n");
	     int sortingParams=sc.nextInt();
	       
	     switch (sortingParams){
	            case 1:
	            	System.out.println("Price low to high:");
	            	Collections.sort(AdList, lastest.Pricecomparator);
	            	for(lastest str: AdList){
	            		displayads(str);
	            	}
	            	break;
	            case 2: 
	            	System.out.println("Price high to low:");
	            	Collections.sort(AdList, lastest.Pricecomparator1);
	            	for(lastest str: AdList){
	            		displayads(str);
	            	}
	                break;
	            case 3:
	            	System.out.println("Newest Adertisement");
	            	Connection cDB=getConnect();
	      		  	if(cDB!=null){
	      		  		Statement st=null;
	      		  		String sql="select * from advertising.listofads order by timestamps desc";
	      		  		try {
	      		  			st=cDB.createStatement();
	      		  			ResultSet rs=st.executeQuery(sql);
	      		  			int i=0;
	      		  			while(rs!= null && rs.next() && i==0){
	      		  				i++;
	      		  				int id=rs.getInt("id"); 
	      		  				String adname=rs.getString("adname");
	      		  				String ownername=rs.getString("ownername");
	      		  				String publisher=rs.getString("publisher");
	      		  				String type=rs.getString("type");
	      		  				int price=rs.getInt("price"); 
	      		  				Date date=rs.getDate("timestamps");
	      		  				int popularity=rs.getInt("popularity");
	      		  				lastest b1=new lastest(id,adname,ownername,publisher,type,price,date,popularity); 
	      		  				//AdList.add(b1);
	      		  				displayads(b1);
	      		  			}
	      		  		}
	      		  		catch (Exception e) {
	      		  			e.printStackTrace();
					}
	      		  	}
	            	break;
	            case 4:
	            	System.out.println("Advertisement shown on the basis of the popularity");
	            	Collections.sort(AdList, lastest.popularitycomparator);
	            	for(lastest str: AdList){
	            		displayads(str);
	            	}
	                break;
	             default:   
	              System.out.println("Choose from the above 4 options");
	              break;
	            }
	}
	
	static void searchAds()
	{
		System.out.println("Enter the keystring");
	     String key = sc.next();
	     for(int i=0;i<AdList.size();i++)
	     {
	      lastest l1=AdList.get(i);
	      String adname=l1.getadName();
	      if(adname.contains(key))
	       displayads(l1);
	     }
	}
	
static void filterAds(){
     
     System.out.println("Enter the price range");
     String range = sc.next();
     String[] rn = range.split("-");
     int lowerlimit = Integer.parseInt(rn[0]);
     int upperlimit = Integer.parseInt(rn[1]);
     for(int i=0;i<AdList.size();i++)
     {
      lastest l1=AdList.get(i);
      int price1=l1.getPrice();
      if(price1>=lowerlimit & price1<=upperlimit)
       displayads(l1);
     }
    }

	
static void displayads(lastest l1){
     int id = l1.getID(); 
     String adname = l1.getadName();  
     String owner = l1.getownerName(); 
     String publisher = l1.getpublisherName(); 
     String type = l1.getType();
     int price = l1.getPrice();; 
     Date date =l1.getDate() ;
     int popularity = l1.getPopularity();
     System.out.print(id+" ");
     System.out.print(adname+" ");
     System.out.print(owner+" ");
     System.out.print(publisher+" ");
     System.out.print(type+" ");
     System.out.print(price+" ");
     System.out.print(date+" ");
     System.out.println(popularity);
    }

}
