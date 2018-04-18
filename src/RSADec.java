import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class RSADec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in) ;
		System.out.print("Enter path to encrypted text :");
		String dataPath = scanner.nextLine();
		System.out.print("Enter path to keyfile :");
		String keyPath = scanner.nextLine();
		try {
			BufferedReader keyFile = new BufferedReader(new FileReader(keyPath));
			FileInputStream in = new FileInputStream(dataPath);
			BufferedReader inReader = new BufferedReader(new InputStreamReader(in));
			BigInteger key = new BigInteger(keyFile.readLine());
			BigInteger N = new BigInteger(keyFile.readLine());
			FileOutputStream out = new FileOutputStream(dataPath+".dec");
			String input=inReader.readLine();
			while(input!=null && input.length()>0) {
				BigInteger result = new BigInteger(Base64.decode(input));
				out.write(result.modPow(key, N).intValue());
				input=inReader.readLine();
			}
			out.close();
			inReader.close();
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
