import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Scanner;

public class rsa {
    private final static SecureRandom random = new SecureRandom();
    private final static BigInteger one = BigInteger.ONE;

    private BigInteger n;
    private BigInteger m;
    private BigInteger e;
    private BigInteger d;

    public rsa() {
        BigInteger p = BigInteger.probablePrime(32, random);
        BigInteger q = BigInteger.probablePrime(32, random);

        n = p.multiply(q);
        m = (p.subtract(one)).multiply(q.subtract(one));

        do {
            e = BigInteger.probablePrime(16, random);
        } while ((m.gcd(e)).equals(one) != true);


        d = e.modInverse(m);
    }

    BigInteger encrypt(BigInteger message) {
        return message.modPow(e, n);
    }

    BigInteger decrypt(BigInteger encrypt) {
        return encrypt.modPow(d, n);
    }

    public void rsaNumber() {
        rsa key = new rsa();
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        BigInteger bI = new BigInteger(Integer.toString(num));

        String s = "";
        s += "message: " + bI + "\n";
        s += "encrypt: " + key.encrypt(bI) + "\n";
        System.out.println(s);

    }

    public static void main(String argv[]) throws IOException {
        rsa key = new rsa();

        FileHandle ri = new FileHandle();
        byte[] b = ri.readFile();

        BigInteger bigI = new BigInteger(b);
        BigInteger bigIEncrypt = key.encrypt(bigI);

        byte[] b_out = bigIEncrypt.toByteArray();
        ri.writeFile(b_out);

        System.out.println("\nDone Encrypt");
    }
}
