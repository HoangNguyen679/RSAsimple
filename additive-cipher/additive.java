import java.util.*;

public class additive
{
    private final int KEY = 1;
    private final int LENGTH = 26;

    public String encrypt(String mess)
    {
	String encrypt = "";
	
	for (int i = 0; i < mess.length(); i++)
	    {
		int before = mess.charAt(i) + KEY;
		char after = before > (97 + KEY) ? (char)(before % 97 + 97) : (char)(before % 65 + 65) ;
		encrypt += after ;
	    }

	return encrypt;
    }

    public static void main(String argv[])
    {
	additive key = new additive();
	String sample = "Nguyen Duc Hoang";
	
	String encrypt = new String();
	encrypt = key.encrypt(sample);
	System.out.println(encrypt);
    }
}
