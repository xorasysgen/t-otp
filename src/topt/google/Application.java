package topt.google;

import java.io.IOException;
import java.util.Scanner;

import com.google.zxing.WriterException;

public class Application {

	public static void main(String[] args) throws IOException, WriterException {
        String secretKey = "QWERTYUIOPLKJHGFDSAZXCVBNMPOIUYT";// must be 32 CHARACTER String
        String email = "sushil_bhaskar@hotmail.com";
        String companyName = "Sushil";
        String barCodeUrl = Utils.getGoogleAuthenticatorBarCode(secretKey, email, companyName);
        System.out.println(barCodeUrl);
        Utils.createQRCode(barCodeUrl, "QRCode.png", 400, 400);

        Scanner scanner = new Scanner(System.in);
        String code = scanner.nextLine();
        if (code.equals(Utils.getTOTPCode(secretKey))) {
            System.out.println("Logged in successfully");
        } else {
            System.out.println("Invalid 2FA Code");
        }

    }
}
