import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		System.out.println("Enter\n1. Registered User\n2. First Time Visitor\n");
		Scanner scan=new Scanner(System.in);
		int input;
		input=scan.nextInt();
		Authentication a=new Authentication();
		Visitor v=new Visitor();
		switch (input) {
		case 1:
			
			System.out.println("Enter username and password");
			String userName, passWord;
			userName=scan.next();
			passWord=scan.next();
			boolean check=a.authenticate(userName, passWord);
			if(check){
				System.out.println("Login Successful\n1. Edit Profile\n2. Design Ad\n3. ModifyAd\n" +
						"4. Delete ad\n"+"5. View ads");
				int input2=scan.nextInt();
				Client u=new Client();
				switch (input2) {
				case 1:
					u.editUserProfile();
					break;
					
				case 2:
					u.designingAd();
					break;
				
				case 3:
					u.modifyAd();
					break;
				
				case 4:
					u.deleteAd();
					break;
				case 5:
					Advertisement ad=new Advertisement();
					ad.iNeedThisMethod();
				default:
					break;
				}
				
				
			}
			else{
				System.out.println("Login Failed! Tata \n");
			}
			break;
			
		case 2:
			
			System.out.println("1. Register\n2. Read Blog\n3. View ads");
			int input2=scan.nextInt();
			switch (input2) {
			
			case 1:
				System.out.println("Enter name, email,username, password, confirmpassword,contact\n");
				String name,email,username, password, confirmpassword;
				long contactNumber;
				name=scan.next();
				email=scan.next();
				username=scan.next();
				password=scan.next();
				confirmpassword=scan.next();
				contactNumber=scan.nextLong();
				v.register(name, email, username, password, confirmpassword,contactNumber);
				break;
				
			case 2:
				v.readBlog();
				break;
			case 3:
				Advertisement ad=new Advertisement();
				ad.iNeedThisMethod();
				break;
			default:
				break;
			}
			
		default:
			break;
		}
		scan.close();
	}

}
