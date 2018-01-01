import java.math.BigInteger;
import java.security.SecureRandom;

public class rsa
{
    private final static SecureRandom random = new SecureRandom();
    private final static BigInteger one = BigInteger.ONE;

    private BigInteger n;
    private BigInteger e;
    private BigInteger d;

    rsa()
    {
	BigInteger p = BigInteger.probablePrime(32, random);
	BigInteger q = BigInteger.probablePrime(32, random);

	n = p.multiply(q);
	BigInteger m = (p.subtract(one)).multiply(q.subtract(one));

	do {
	    e = BigInteger.probablePrime(16, random);
	} while ((m.gcd(e)).equals(one) != true);

	d = e.modInverse(m);
    }

    BigInteger encrypt(BigInteger message)
    {
	return message.modPow(e,n);
    }

    BigInteger decrypt(BigInteger encrypt)
    {
	return encrypt.modPow(d,n);
    }
    
    public static void main(String argv[])
    {
	
	rsa key = new rsa();
	
	BigInteger message = new BigInteger("50");
       
	String s = "";
	s += "message: " + message + "\n";
	s += "encrypt: " + key.encrypt(message) + "\n";
	s += "decrypt: " + key.decrypt(key.encrypt(message)) + "\n";

	System.out.println(s);
    }
}
