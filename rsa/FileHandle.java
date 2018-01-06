import java.io.*;

/**
 * Created by Nguyen on 1/5/2018.
 */
public class FileHandle {
    private final String inputFilePath = "text/sample";
    private final String outputFilePath = "text/output";

    public byte[] readFile() throws IOException {
        File f = new File(inputFilePath);
        FileInputStream fi = new FileInputStream(f);

        byte[] bytes = null;
        long fileSize = f.length();
        if ( fileSize > Integer.MAX_VALUE ) {
            System.out.println("File to big!");
        }

        bytes = new byte[(int)fileSize];

        int numRead = 0;
        int total = 0;
        while ((numRead = fi.read(bytes)) != -1) {
            total += numRead;
        }

        return bytes;
    }

    public void writeFile(byte[] bytes) throws IOException {
        File f = new File(outputFilePath);
        FileOutputStream fo = new FileOutputStream(f);

        if( !f.exists() )
            f.createNewFile();

        fo.write(bytes);
        fo.flush();
        fo.close();
    }

}
