package network.common.wechatUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import com.alibaba.fastjson.JSONObject;

public class TokenUtil {
    public static Token token = null;

    public static Token getToken() {
        if (token == null) {
            token = getToken1();
        }
        return token;
    }

    private static Token getToken1() {
        try {
            String appid = "wx39b5d81dba20a59e";
            String appSecret = "14d2ceb14c372b064b286546c55a7f59";
            String tokenUrl =
                    "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appid + "&secret=" + appSecret;
            // 建立连接
            URL url = new URL(tokenUrl);
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();

            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = {new MyX509TrustManager()};
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            httpUrlConn.setSSLSocketFactory(ssf);
            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);

            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod("GET");

            // 取得输入流
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            // 读取响应内容
            StringBuffer buffer = new StringBuffer();
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            httpUrlConn.disconnect();
          

            JSONObject jsonObject = JSONObject.parseObject(buffer.toString());
            if (null != jsonObject) {
                Token token = new Token();
                token.setAccessToken(jsonObject.getString("access_token"));
                token.setExpiresIn(jsonObject.getIntValue("expires_in"));
                return token;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException {
        System.out.println(getToken().getAccessToken() + "  " + getToken().getExpiresIn());
    }
}
