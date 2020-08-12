import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class S {

    public static void main(String[] args) throws IOException {
        int port = Integer.parseInt(args[0]);

        ServerSocket ss = new ServerSocket();
        ss.bind(new InetSocketAddress("0.0.0.0", port));
        System.out.println(ss);
        Socket s;
        while( (s = ss.accept()) != null ){
            System.out.println(s);
            BufferedInputStream sin = new BufferedInputStream( s.getInputStream());

//            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
//            String input;
//            while(!"end".equalsIgnoreCase(input = reader.readLine())){
//                System.out.println(input);
//            }

            File tmp = File.createTempFile("tmp-",".file");
            FileOutputStream fout = new FileOutputStream(tmp);
            int len; byte [] buffer = new byte[1024*8];
            while((len=sin.read(buffer)) > 0){
                fout.write(buffer,0,len);
            }
            fout.flush();
            fout.close();
            System.out.println(tmp.length() + ":" + tmp.getAbsolutePath());
            sin.close();
            s.close();
        }
    }
}
