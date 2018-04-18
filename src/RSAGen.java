// CopyLeft Abhiram Shibu Year 2018
// Use it with caution, utra fast encryption
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class RSAGen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//High Quality Prime generator
		final int PRIME_TOUGHNESS=256;
		final int PUBLIC_KEY_TOUGHNES=PRIME_TOUGHNESS/2;
		long millis=System.currentTimeMillis();
		long millisFinal=millis;
		BigInteger oneBigInteger = BigInteger.probablePrime(PRIME_TOUGHNESS, new Random());
		BigInteger twoBigInteger = BigInteger.probablePrime(PRIME_TOUGHNESS, new Random());
		millis=System.currentTimeMillis()-millis;
		System.out.println("First Prime:"+oneBigInteger+"\n"
						  +"Second Prime:"+twoBigInteger+"\n"
						  +"Time taken (ms) :"+millis);
		BigInteger N = oneBigInteger.multiply(twoBigInteger);
		
		int K=Math.abs(new Random().nextInt());
		System.out.println("Key ="+K);
		BigInteger n = (oneBigInteger.subtract(new BigInteger("1"))
								.multiply(twoBigInteger.subtract(new BigInteger("1"))));
		BigInteger publicKey =  BigInteger.probablePrime(128, new Random());
		while(!n.gcd(publicKey).equals(new BigInteger("1"))) {
			publicKey =  BigInteger.probablePrime(PUBLIC_KEY_TOUGHNES, new Random());
		}
		BigInteger privateKey = (n.multiply(new BigInteger(""+K)).add(new BigInteger("1"))).divide(publicKey);
		millisFinal=System.currentTimeMillis()-millisFinal;
		System.out.println("Public Key ="+publicKey+"\n"+
							"Private Key ="+privateKey+"\n"+
							"Total time taken :"+((float)millisFinal/1000)+" sec");
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a path:");
		String priv = scanner.nextLine();
		String pub = priv+".pub";
		scanner.close();
		try {
			PrintWriter PRIV = new PrintWriter(new FileWriter(priv));
			PrintWriter PUB = new PrintWriter(new FileWriter(pub));
			PRIV.println(privateKey+"");
			PRIV.println(N+"");
			PUB.println(publicKey+"");
			PUB.println(N+"");
			PRIV.close();
			PUB.close();
			System.out.println("Write Success!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error occured while writing file!");
		}
	}
}
