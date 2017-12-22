package network.controller;

import com.alibaba.fastjson.JSONObject;
import network.common.AccessToken;
import network.common.HttpXmlClient;
import network.common.JsApiTicket;
import network.common.ServletContextUtil;
import network.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.*;


@Controller
@RequestMapping(value = "registration")
public class RegistrationCtr {
    @Autowired
    private RegistrationService registrationService;

    @RequestMapping(value = "/redirect.do")
    public String wechatRedirect(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return "redirect:https://open.weixin.qq.com/connect/oauth2/authorize?" +
                "appid=wx39b5d81dba20a59e&" +
                "redirect_uri=http://47.100.116.100/network/registration/registration.do" +
                "&response_type=code&scope=snsapi_base&state=123#wechat_redirect";
    }

    @RequestMapping("/registration.do")
    public ModelAndView registration(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("registration");

        String CODE = request.getParameter("code");
        String APPID = "wx39b5d81dba20a59e";
        String SECRET = "14d2ceb14c372b064b286546c55a7f59";
        //换取access_token 其中包含了openid
        Map<String, String> idparams = new HashMap<String, String>();
        idparams.put("appid", APPID);
        idparams.put("secret", SECRET);
        try{
            idparams.put("code", URLEncoder.encode(CODE,"UTF-8"));
        }catch (Exception e){
            e.printStackTrace();
        }
        idparams.put("grant_type", "authorization_code");
        //URLConnectionHelper是一个模拟发送http请求的类
        String idXml = HttpXmlClient.post("https://api.weixin.qq.com/sns/oauth2/access_token", idparams);
        mav.addObject("idXml", idXml);
        JSONObject idJsonMap = JSONObject.parseObject(idXml);
        String openid = null;
        if (idJsonMap.get("openid") != null) {
            openid = idJsonMap.get("openid").toString();
        }


        //获取access_token
        AccessToken accessToken = (AccessToken) ServletContextUtil.get().getAttribute("ACCESS_TOKEN");

        String access_token = accessToken.getToken();
        Map<String, String> params = new HashMap<String, String>();

        //获取ticket
        JsApiTicket jsApiTicket = (JsApiTicket) ServletContextUtil.get().getAttribute("JSAPI_TICKET");
        String jsapi_ticket = jsApiTicket.getTicket();



        //获取签名signature
        String noncestr = UUID.randomUUID().toString();
        String timestamp = Long.toString(System.currentTimeMillis() / 1000);
        //获取请求url

        StringBuffer uri = request.getRequestURL();
        String url = uri.toString();
        //获取所有请求,返回Map集合,遍历
        Map<String, String[]> paramMap = request.getParameterMap();
        Set<Map.Entry<String, String[]>> entry = paramMap.entrySet();
        Iterator<Map.Entry<String, String[]>> iterator = entry.iterator();

        //遍历集合
        StringBuffer sb = new StringBuffer();
        while (iterator.hasNext()) {
            Map.Entry<String, String[]> item = iterator.next();
            //请求名
            String key = item.getKey();
            //请求值
            for (String value : item.getValue()) {
                //拼接每个请求参数   key=value&
                try {
                    sb.append(key + "=" + URLEncoder.encode(value, "UTF-8") + "&");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        String string = sb.toString();
        //拼接URL,   URL?key=value&key=value&   并且去掉最后一个&
        if (string.contains("&"))
            url = url + "?" + string.substring(0, string.lastIndexOf("&"));
        if (string.contains("#"))
            url = url.substring(0, string.lastIndexOf("#"));
        mav.addObject("url", url);
        String str = "jsapi_ticket=" + jsapi_ticket +
                "&noncestr=" + noncestr +
                "&timestamp=" + timestamp +
                "&url=" + url;
        //sha1加密
        String signature = HttpXmlClient.SHA1(str);
        mav.addObject("signature", signature);
        mav.addObject("timestamp", timestamp);
        mav.addObject("noncestr", noncestr);
        mav.addObject("appId", APPID);
        mav.addObject("openId", openid);
        return mav;

    }

    @RequestMapping(value = "/addRegistration.do")
    public @ResponseBody
    Map<String, Object> login(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<String, Object>();
        String openId = request.getParameter("openId").toString();
        double location_x = Double.parseDouble(request.getParameter("location_x"));
        double location_y = Double.parseDouble(request.getParameter("location_y"));
        Date date = null;
        try {
             date = new Date(Long.parseLong(request.getParameter("date")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        int state = registrationService.registration(location_x, location_y, openId, date);

        map.put("state", state);
        return map;
    }

}
