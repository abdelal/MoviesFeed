package ali.test.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


public class HTTPUtils {

    public static InputStream getInputStrem(String url) throws IOException{
        URL mUrl = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) mUrl.openConnection();
        InputStream in = con.getInputStream();
        return in;
    }


}
