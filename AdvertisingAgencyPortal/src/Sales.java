import java.util.Random;
import java.util.Scanner;


public class Sales {
	String Product;
	String Locations;
	String Category;
	int Budget;
	String Medium;
	public static final String list="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final int length=7;
	Scanner scan=new Scanner(System.in);
	
	void preMarketAnalysis(){
		System.out.println("These are some suggestions");
		System.out.println(generateRandomString());
	}
	
	void postMarketAnalysis(){
		System.out.println("These are some suggestions, because it's never too late to change ;)");
		System.out.println(generateRandomString());
	}
	
	void publishing(){
		System.out.println("Enter the mediums of preferences(separate with a comma)");
		String list=scan.next();
		System.out.println("Do you wish to opt for market analysis?\nPress 1 for yes\nPress 0 for no");
		int i=scan.nextInt();
		if(i==1){
			preMarketAnalysis();
		}
		System.out.println("Ad Published! Have fun with the new customers!");
		Payment p=new Payment();
		p.payment();
		if(i==1){
			postMarketAnalysis();
		}
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
