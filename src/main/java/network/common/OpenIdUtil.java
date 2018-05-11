package network.common;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class OpenIdUtil {
    public static String getOpenId(String CODE) {
        String appid = AppUtil.getAppId();
        String appsecret = AppUtil.getAppsecret();
        //换取access_token 其中包含了openid
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("https://api.weixin.qq.com/sns/oauth2/access_token?");
        stringBuffer.append("appid=");
        stringBuffer.append(appid);
        stringBuffer.append("&secret=");
        stringBuffer.append(appsecret);
        stringBuffer.append("&code=");
        stringBuffer.append(CODE);
        stringBuffer.append("&grant_type=authorization_code");

        JSONObject idJsonMap = AccessTokenUtil.httpRequest(stringBuffer.toString(), "GET", null);
        String openId = idJsonMap.get("openid").toString();
        return openId;

    }
}
