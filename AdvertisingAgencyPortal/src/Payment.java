import java.util.*;
public class Payment {
	String PaymentMode;
	int PayableAmount;
	
	void payment(){
		System.out.println("Enter coupon number to avail discount");
		Scanner scan=new Scanner(System.in);
		String s=scan.next();
		Random rand=new Random();
		int r=rand.nextInt(10);
		if(r<5){
			System.out.println("Coupon Validation Successful");
		}
		else{
			System.out.println("Sorry, this coupon is not applicable");
		}
		System.out.println("Enter the type of card");
		String card=scan.next();
		System.out.println("Enter the bank name");
		String bank=scan.next();
		System.out.println("Proceeding to the card site.....");
		
	}
}
