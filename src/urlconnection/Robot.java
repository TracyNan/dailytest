package urlconnection;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Robot {
    public static void main(String[] args) {
        URL url = null;
        URLConnection urlconn = null;
        BufferedReader br = null;
        PrintWriter pw = null;
        // String regex = "http://[\\w+\\.?/?]+\\.[A-Za-z]+";
        String regex = "https://[\\w+\\.?/?]+\\.[A-Za-z]+";// url鍖归厤瑙勫垯
        Pattern p = Pattern.compile(regex);
        try {
            url = new URL("http://www.12306.cn/mormhweb/");// 鐖彇鐨勭綉鍧�銆佽繖閲岀埇鍙栫殑鏄竴涓敓鐗╃綉绔�
            urlconn = url.openConnection();
            pw = new PrintWriter(new FileWriter("D:a.txt"), true);// 灏嗙埇鍙栧埌鐨勯摼鎺ユ斁鍒癉鐩樼殑SiteURL鏂囦欢涓�
            br = new BufferedReader(new InputStreamReader(
                    urlconn.getInputStream()));
            String buf = null;
            while ((buf = br.readLine()) != null) {
                Matcher buf_m = p.matcher(buf);
                while (buf_m.find()) {
                    pw.println(buf_m.group());
                }
            }
            System.out.println("鐖彇鎴愬姛^_^");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            pw.close();
        }
    }
}
