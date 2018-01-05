import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;

public class rsa {
    private final static SecureRandom random = new SecureRandom();
    private final static BigInteger one = BigInteger.ONE;

    private BigInteger n;
    private BigInteger e;
    private BigInteger d;

    rsa() {
//	BigInteger p = BigInteger.probablePrime(32, random);
//	BigInteger q = BigInteger.probablePrime(32, random);

        BigInteger p = new BigInteger("19");
        BigInteger q = new BigInteger("23");

        n = p.multiply(q);
        BigInteger m = (p.subtract(one)).multiply(q.subtract(one));

//        do {
//            e = BigInteger.probablePrime(16, random);
//        } while ((m.gcd(e)).equals(one) != true);

        e = new BigInteger("113");

        d = e.modInverse(m);
    }

    BigInteger encrypt(BigInteger message) {
        return message.modPow(e, n);
    }

    BigInteger decrypt(BigInteger encrypt) {
        return encrypt.modPow(d, n);
    }

    public static void main(String argv[]) throws IOException {

        rsa key = new rsa();

        BigInteger message = new BigInteger("50");

        String s = "";
        s += "message: " + message + "\n";
        s += "encrypt: " + key.encrypt(message) + "\n";
        s += "decrypt: " + key.decrypt(key.encrypt(message)) + "\n";

        System.out.println(s);

        ReadInput ri = new ReadInput();
        byte[] b = null;
        b = ri.readFile();
        System.out.println(new String(b));

        int i = 0;
        do {
            byte[] tmp = new byte[2];
            tmp[0] = b[i];
            tmp[1] = b[i + 1];
            BigInteger bigI = new BigInteger(tmp);
            BigInteger out = key.encrypt(bigI);
            //System.out.print(out);
            System.out.print(out.toString());
            i = i + 2;
        } while (i < b.length);
    }
}
