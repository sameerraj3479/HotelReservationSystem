import java.util.Random;
import java.util.Scanner;

public class OTP {

    public static boolean verifyOTP() {

        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        int otp = 100000 + random.nextInt(900000);

        System.out.println("\n========== OTP VERIFICATION ==========");
        System.out.println("Your OTP is : " + otp);

        System.out.print("Enter OTP : ");
        int userOtp = sc.nextInt();

        if (userOtp == otp) {

            System.out.println("OTP Verified Successfully!");
            return true;

        } else {

            System.out.println("Invalid OTP!");
            return false;

        }
    }
}