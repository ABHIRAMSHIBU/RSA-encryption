import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class RSAEnc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Example /home/user/key.pub is public key\n"
				         + "/home/user/key is private key\n"
				         + "You are free to use any one"
				         + "Use other key to decrypt");
		System.out.print("Enter path to key :");
		String keyPath = scanner.nextLine();
		try {
			BufferedReader keyFile = new BufferedReader(new FileReader(new File(keyPath)));
			BigInteger key = new BigInteger(keyFile.readLine());
			BigInteger N = new BigInteger(keyFile.readLine());
			System.out.print("Enter path to uncrypted file :");
			String DataFile = scanner.nextLine();
			FileInputStream in=new FileInputStream(DataFile);
			PrintWriter out= new PrintWriter(DataFile+".enc");
			int i=in.read();
			while(in.available()>0) {
				BigInteger result = new BigInteger(i+"").modPow(key, N);
				String temp=Base64.encode(result.toByteArray());
				out.println(temp);
				i=in.read();
			}
			out.flush();
			in.close();
			out.close();
			keyFile.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scanner.close();
	}

}
