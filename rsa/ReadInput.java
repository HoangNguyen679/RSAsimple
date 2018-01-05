import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Nguyen on 1/5/2018.
 */
public class ReadInput  {
    private final String inputFilePath = "text/sample.txt";
    private final String outputFilePath = "text/output.txt";

    public byte[] readFile() throws IOException {
        File f = new File(inputFilePath);
        FileInputStream fi = new FileInputStream(f);

        byte[] bytes = null;
        long fileSize = f.length();
        if ( fileSize > Integer.MAX_VALUE ) {
            System.out.println("File to big!");
        }

        bytes = new byte[(int)fileSize];
        int offset = 0;
        int numRead = 0;
        while ( offset < bytes.length &&
                (numRead = fi.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }

        return bytes;
    }
}
