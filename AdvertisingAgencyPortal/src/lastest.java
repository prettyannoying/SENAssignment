import java.util.*;
import java.util.Comparator;
public class lastest {
  int id; 
  String adname,owner,publisher,type; 
  int price; 
  Date date;
  int popularity;
  public lastest(int id, String name, String owner, String publisher, String type, int price, Date date, int popularity ) { 
      this.id = id; 
      this.adname = name; 
      this.owner = owner; 
      this.publisher = publisher; 
      this.type = type;
      this.price = price; 
      this.date = date;
      this.popularity = popularity;
  }
  public int getID() {
   return id;
  }
  public void setID(int ID) {
   this.id = ID;
  }
  public String getadName() {
   return adname;
  }
  public void setadName(String adname) {
   this.adname = adname;
  }
  public String getownerName() {
   return owner;
  }
  public void setownerName(String owner) {
   this.owner = owner;
  }
  public String getpublisherName() {
   return publisher;
  }
  public void setpublisherName(String publisher) {
   this.publisher = publisher;
  }
  public String getType() {
   return type;
  }
  public void setType(String type) {
   this.type = type;
  }
  public int getPrice() {
   return price;
  }
  public void setPrice(int Price) {
   this.price = Price;
  }
  public Date getDate() {
   return date;
  }
  public void setDate(Date date) {
   this.date = date;
  }
  public int getPopularity() {
   return popularity;
  }
  public void setPopularity(int popularity) {
   this.popularity = popularity;
  }
     
   public static Comparator<lastest> popularitycomparator = new Comparator<lastest>() {
    public int compare(lastest a1, lastest a2) {
       int adpop1 = a1.getPopularity();
       int adpop2 = a2.getPopularity();
       return adpop2-adpop1;
       }};
       /*Comparator for sorting the list by roll no*/
       public static Comparator<lastest> Pricecomparator = new Comparator<lastest>() {
    public int compare(lastest a1, lastest a2) {
       int adprice1 = a1.getPrice();
       int adprice2 = a2.getPrice();
       /*For ascending order*/
       return adprice1-adprice2;
       /*For descending order*/
       //rollno2-rollno1;
      }};
      public static Comparator<lastest> Pricecomparator1 = new Comparator<lastest>() {
     public int compare(lastest a1, lastest a2) {
        int adprice1 = a1.getPrice();
        int adprice2 = a2.getPrice();
        /*For ascending order*/
       // return adprice1-adprice2;
        /*For descending order*/
        return adprice2-adprice1;
       }};
    /*
     * public static Comparator<lastest> Newcomparator = new Comparator<lastest>() {
      public Date compare(lastest a1, lastest a2) {
         Date addate1 = a1.getDate();
         Date addate2 = a2.getDate();
         return addate2.compareTo(addate1);
         }};*/
     
}