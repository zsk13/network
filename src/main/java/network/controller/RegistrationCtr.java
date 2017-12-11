package network.controller;

import com.alibaba.fastjson.JSONObject;
import network.common.HttpXmlClient;
import network.common.wechatUtil.Token;
import network.common.wechatUtil.TokenUtil;
import network.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
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
        String CODE = request.getParameter("code");
        String APPID = "wx39b5d81dba20a59e";
        String SECRET = "14d2ceb14c372b064b286546c55a7f59";
        //换取access_token 其中包含了openid
        Map<String, String> idparams = new HashMap<String, String>();
        idparams.put("appid", APPID);
        idparams.put("secret", SECRET);
        idparams.put("code", CODE);
        idparams.put("grant_type", "authorization_code");
        //URLConnectionHelper是一个模拟发送http请求的类
        String idXml = HttpXmlClient.post("https://api.weixin.qq.com/sns/oauth2/access_token", idparams);
        JSONObject idJsonMap = JSONObject.parseObject(idXml);
//        JSONObject jsonObject = WeixinUtil.httpRequest("https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + APPID + "&secret=" + SECRET + "&code=" + CODE + "&grant_type=authorization_code ", "POST", null);
        String openid = null;
        if (idJsonMap.get("openid") != null) {
            openid = idJsonMap.get("openid").toString();
        }


        ModelAndView mav = new ModelAndView("registration");
        //获取access_token
        Token token = TokenUtil.getToken();
        String access_token = token.getAccessToken();
        Map<String, String> params = new HashMap<String, String>();
//        params.put("appid", APPID);
//        params.put("secret", SECRET);
//        String xml = HttpXmlClient.post("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential", params);
//        JSONObject jsonMap = JSONObject.fromObject(xml);
//        Map<String, String> map = new HashMap<String, String>();
//        Iterator<String> it = jsonMap.keys();
//        while (it.hasNext()) {
//            String key = (String) it.next();
//            String u = jsonMap.get(key).toString();
//            map.put(key, u);
//        }
//        String access_token = map.get("access_token");

        //获取ticket
        params.put("access_token", access_token);
        params.put("type", "jsapi");
        String xml = HttpXmlClient.post("https://api.weixin.qq.com/cgi-bin/ticket/getticket", params);
        JSONObject jsonMap = JSONObject.parseObject(xml);
//        Map<String, String> map = new HashMap<String, String>();
//        Iterator<String> it = jsonMap.keys();
//        while (it.hasNext()) {
//            String key = (String) it.next();
//            String u = jsonMap.get(key).toString();
//            map.put(key, u);
//        }
        // jsonObject = WeixinUtil.httpRequest("https://api.weixin.qq.com/cgi-bin/ticket/getticket", "GET", JSONObject.toJSONString(params));
        String jsapi_ticket = null;
        if (jsonMap.get("ticket") != null) {
            jsapi_ticket = jsonMap.get("ticket").toString();
        }


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
                sb.append(key + "=" + value + "&");
            }
        }

        String string = sb.toString();
        //拼接URL,   URL?key=value&key=value&   并且去掉最后一个&
        if (string.contains("&"))
            url = url + "?" + string.substring(0, string.lastIndexOf("&"));

        // String path = request.getContextPath();
        //以为我配置的菜单是http://yo.bbdfun.com/first_maven_project/，最后是有"/"的，所以url也加上了"/"
        // String url = request.getScheme() + "://" + request.getServerName() + path;
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(request.getParameter("date").toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        int state = registrationService.registration(location_x, location_x, openId, date);

        map.put("state", state);
        return map;
    }

}
