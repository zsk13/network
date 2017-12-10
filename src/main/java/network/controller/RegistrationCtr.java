package network.controller;

import net.sf.json.JSONObject;
import network.common.HttpXmlClient;
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
        idparams.put("code",CODE);
        idparams.put("grant_type","authorization_code");
        //URLConnectionHelper是一个模拟发送http请求的类
        String idXml = HttpXmlClient.post("https://api.weixin.qq.com/sns/oauth2/access_token", idparams);
        JSONObject idJsonMap = JSONObject.fromObject(idXml);
        Map<String, String> idMap = new HashMap<String, String>();
        Iterator<String> idIt = idJsonMap.keys();
        while (idIt.hasNext()) {
            String key = (String) idIt.next();
            String u = idJsonMap.get(key).toString();
            idMap.put(key, u);
        }
        String openid = idMap.get("openid").toString();

        ModelAndView mav = new ModelAndView("registration");
        //获取access_token
        Map<String, String> params = new HashMap<String, String>();
        params.put("appid", APPID);
        params.put("secret", SECRET);
        String xml = HttpXmlClient.post("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential", params);
        JSONObject jsonMap = JSONObject.fromObject(xml);
        Map<String, String> map = new HashMap<String, String>();
        Iterator<String> it = jsonMap.keys();
        while (it.hasNext()) {
            String key = (String) it.next();
            String u = jsonMap.get(key).toString();
            map.put(key, u);
        }
        String access_token = map.get("access_token");

        //获取ticket
        params.put("access_token", access_token);
        params.put("type", "jsapi");
        xml = HttpXmlClient.post("https://api.weixin.qq.com/cgi-bin/ticket/getticket", params);
        jsonMap = JSONObject.fromObject(xml);
        map = new HashMap<String, String>();
        it = jsonMap.keys();
        while (it.hasNext()) {
            String key = (String) it.next();
            String u = jsonMap.get(key).toString();
            map.put(key, u);
        }
        String jsapi_ticket = map.get("ticket");


        //获取签名signature
        String noncestr = UUID.randomUUID().toString();
        String timestamp = Long.toString(System.currentTimeMillis() / 1000);
        //获取请求url
        String path = request.getContextPath();
        //以为我配置的菜单是http://yo.bbdfun.com/first_maven_project/，最后是有"/"的，所以url也加上了"/"
        String url = request.getScheme() + "://" + request.getServerName() + path + "/";
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
        mav.addObject("openId",openid);
        return mav;

    }
    @RequestMapping(value="/addRegistration.do")
    public @ResponseBody Map<String,Object> login(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> map = new HashMap<String,Object>();
        String openId = request.getParameter("openId").toString();
        double location_x = Double.parseDouble(request.getParameter("lcoation_x"));
        double location_y = Double.parseDouble(request.getParameter("lcoation_y"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(request.getParameter("date").toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        int state = registrationService.registration(location_x,location_x,openId,date);

            map.put("state",state);
            return map;
    }

}
