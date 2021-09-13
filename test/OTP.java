import java.util.Random;

public class OTP{
	public static void main(String[] args){
		createOTP();
	}
	public static String createOTP(){
		StringBuffer sbw = new StringBuffer();

		Random random = new Random();
		
		for(int i=1; i<=5 ; i++){
			sbw.append(random.nextInt(10));	
		}
		System.out.println(sbw.toString());

		return sbw.toString();
	}
}