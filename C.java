import java.io.*;
import java.net.Socket;

public class C {
    public static void main(String[] args) throws IOException {
        String host = args[0];
        int port = Integer.parseInt(args[1]);
        String path = args[2];
        File file = new File(args[2].trim());
        if( !file.exists() || !file.isFile() ){
            throw new IllegalArgumentException("Invalid file:" + file.getPath());
        }

        InputStream fin = new FileInputStream(file);
        Socket s = new Socket(host, port);
        OutputStream sout = s.getOutputStream();

        int len; byte[] buffer = new byte[1024*8];
        while( (len = fin.read(buffer)) > 0) {
            sout.write(buffer,0, len);
        }
        s.close();
    }
}
