package network.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Map;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import network.model.User;
import network.model.Users;
import network.service.FollowService;
import network.service.UsersService;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import network.common.XmlToMap;
import network.common.wechatUtil.TextMessage;
import network.common.wechatUtil.WechatMessageUtil;
import network.service.QuestionService;

@Controller
@RequestMapping(value = "wechat")
public class WeChatCtr {
    Log logger = LogFactory.getLog(WeChatCtr.class);
    
    public static final String TOKEN = "wechat";
    
    @Autowired
    private QuestionService questionService;
    private FollowService followService;
    
    @RequestMapping(value = "validate", method = {RequestMethod.GET})
    public void validate(HttpServletRequest request,HttpServletResponse response) throws IOException {
        try {  
            // 开发者提交信息后，微信服务器将发送GET请求到填写的服务器地址URL上，GET请求携带参数  
            String signature = request.getParameter("signature");// 微信加密签名（token、timestamp、nonce。）  
            String timestamp = request.getParameter("timestamp");// 时间戳  
            String nonce = request.getParameter("nonce");// 随机数  
            String echostr = request.getParameter("echostr");// 随机字符串  
            PrintWriter out = response.getWriter();  
            // 将token、timestamp、nonce三个参数进行字典序排序  
            String[] params = new String[] { TOKEN, timestamp, nonce };  
            Arrays.sort(params);  
            // 将三个参数字符串拼接成一个字符串进行sha1加密  
            String clearText = params[0] + params[1] + params[2];  
            String algorithm = "SHA-1";  
            String sign = new String(  
                    Hex.encodeHex(MessageDigest.getInstance(algorithm).digest((clearText).getBytes()), true));  
            // 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信  
            if (signature.equals(sign)) {  
                response.getWriter().print(echostr);  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }
    
    @RequestMapping(value = "validate", method = {RequestMethod.POST})
    public void process(PrintWriter out,HttpServletRequest request,HttpServletResponse response) throws IOException {
        try {  
            // 开发者提交信息后，微信服务器将发送GET请求到填写的服务器地址URL上，GET请求携带参数  
            Map<String, String> map = XmlToMap.xmlToMap(request);
            logger.info(map);
            // 发送方帐号（一个OpenID）
            String fromUserName = map.get("FromUserName");
            // 开发者微信号
            String toUserName = map.get("ToUserName");
            // 消息类型
            String msgType = map.get("MsgType");
            // 默认回复一个"success"
            String responseMessage = "success";
            //消息内容
            String content = map.get("Content");
            // 对消息进行处理
            if (WechatMessageUtil.MESSAGE_TEXT.equals(msgType)) {// 文本消息
                if (content.startsWith("学号：")) {
                    followService.follow(map,out,content);
                    return;
                }
                questionService.dealCommitQuestion(map,out);
                return;
            }else if (msgType.equals(WechatMessageUtil.MESSAGE_EVENT)) {  
                // 事件KEY值，与创建自定义菜单时指定的KEY值对应  
                
                String eventKey = map.get("EventKey");  
                String respContent = "默认";
                if (eventKey.equals("11")) {

                    respContent = "签到菜单项被点击！";

                } else if (eventKey.equals("12")) {  
                    questionService.dealGetQuestion(map,out);
                    return;
                } 
                TextMessage textMessage = new TextMessage();
                textMessage.setMsgType(WechatMessageUtil.MESSAGE_TEXT);
                textMessage.setToUserName(fromUserName);
                textMessage.setFromUserName(toUserName);
                textMessage.setCreateTime(System.currentTimeMillis());
                textMessage.setContent(respContent);
                responseMessage = WechatMessageUtil.textMessageToXml(textMessage);
            }  
            logger.info(responseMessage);
            out.print(responseMessage);
            out.flush();
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }
}
