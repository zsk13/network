package network.common;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import network.common.wechatUtil.MyX509TrustManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.servlet.ServletContext;
import java.io.*;
import java.net.ConnectException;
import java.net.URL;
import java.util.Properties;

public class AccessTokenUtil {
    private static Logger log = LoggerFactory.getLogger(AccessTokenUtil.class);

    // 获取access_token的接口地址（GET）
    public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    //采用http GET方式请求获得jsapi_ticket
    private static final String JSAPI_TICKET = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";

    /**
     * @Description: //设置access_token
     */
    public static void initAndSetAccessToken() {
        log.info("execute initAndSetAccessToken Start : {}", System.currentTimeMillis());
        String appid = AppUtil.getAppId();
        String appsecret = AppUtil.getAppsecret();
        if(appid != null && appsecret !=null) {
            AccessToken accessToken = getAccessToken(appid,appsecret);
            if(null != accessToken) {
                /**
                 * cache access_token
                 */
                ServletContext sc = ServletContextUtil.get();
                sc.removeAttribute("ACCESS_TOKEN");
                sc.setAttribute("ACCESS_TOKEN", accessToken);

                /**
                 * cache jsapi_ticket
                 */
                JsApiTicket jsApiTicket = getJsApiTicket(accessToken.getToken());
                if(null != jsApiTicket) {
                    sc.removeAttribute("JSAPI_TICKET");
                    sc.setAttribute("JSAPI_TICKET", jsApiTicket);
                }
                //这里可以向数据库中写access_token
            }
        } else {
            log.info("execute initAndSetAccessToken appid,appsecret 为空.{}");
        }
        log.info("execute initAndSetAccessToken End   : {}", System.currentTimeMillis());
    }
    /**
     * 获取access_token
     *
     * @param appid 凭证
     * @param appsecret 密钥
     * @return
     */
    public static AccessToken getAccessToken(String appid, String appsecret) {
        AccessToken accessToken = null;

        String requestUrl = access_token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
        JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
        // 如果请求成功
        if (null != jsonObject) {
            try {
                accessToken = new AccessToken();
                accessToken.setToken(jsonObject.getString("access_token"));
                accessToken.setExpiresIn(jsonObject.getInteger("expires_in"));
            } catch (JSONException e) {
                accessToken = null;
                // 获取token失败
                log.error("获取token失败 errcode:{} errmsg:{}", jsonObject.getInteger("errcode"), jsonObject.getString("errmsg"));
            }
        }
        return accessToken;
    }

    /**
     *获取jsapi
     *
     * @param accessToken
     * @return
     */
    public static JsApiTicket getJsApiTicket(String accessToken) {
        JsApiTicket jsApiTicket = null;

        String requestUrl = JSAPI_TICKET.replace("ACCESS_TOKEN", accessToken);
        JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
        // 如果请求成功
        if (null != jsonObject) {
            try {
                jsApiTicket = new JsApiTicket();
                jsApiTicket.setTicket(jsonObject.getString("ticket"));
                jsApiTicket.setExpiresIn(jsonObject.getInteger("expires_in"));
            } catch (JSONException e) {
                accessToken = null;
                // 获取jsApiTicket失败
                log.error("获取jsApiTicket失败 errcode:{} errmsg:{}", jsonObject.getInteger("errcode"), jsonObject.getString("errmsg"));
            }
        }
        return jsApiTicket;
    }

    /**
     * 发起https请求并获取结果
     *
     * @param requestUrl 请求地址
     * @param requestMethod 请求方式（GET、POST）
     * @param outputStr 提交的数据
     * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
     */
    public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {
        JSONObject jsonObject = null;
        StringBuffer buffer = new StringBuffer();
        try {
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = { new MyX509TrustManager() };
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requestUrl);
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
            httpUrlConn.setSSLSocketFactory(ssf);

            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod(requestMethod);

            if ("GET".equalsIgnoreCase(requestMethod))
                httpUrlConn.connect();

            // 当有数据需要提交时
            if (null != outputStr) {
                OutputStream outputStream = httpUrlConn.getOutputStream();
                // 注意编码格式，防止中文乱码
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }

            // 将返回的输入流转换成字符串
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();
            jsonObject = JSONObject.parseObject(buffer.toString());
        } catch (ConnectException ce) {
            log.error("Weixin server connection timed out.");
        } catch (Exception e) {
            log.error("https request error:{}", e);
        }
        return jsonObject;
    }
}
