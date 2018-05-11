package network.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 获取appid和secret
 */
public class AppUtil {

    public static String getAppId() {
        String appid = getProperties().getProperty("APPID");
        return appid;
    }

    public static String getAppsecret() {
        String appsecret = getProperties().getProperty("APPSECRET");
        return appsecret;
    }

    public static String getURL(){
        String URL = getProperties().getProperty("URL");
        return  URL;
    }
    public static Properties getProperties() {
        Properties prop = new Properties();
        try {
            InputStream in = AppUtil.class.getClassLoader().getResourceAsStream("web.properties");
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
