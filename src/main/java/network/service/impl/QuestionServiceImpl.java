package network.service.impl;

import java.io.PrintWriter;
import java.util.Map;

import network.dao.QuestionMapper;
import network.model.Question;
import org.springframework.stereotype.Service;

import network.common.wechatUtil.TextMessage;
import network.common.wechatUtil.WechatMessageUtil;
import network.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{

    BaseService baseService = new BaseService();

    public void dealGetQuestion(Map<String, String> map,PrintWriter out) {
        // TODO Auto-generated method stub
        String question = "1+1=?";
        String fromUserName = map.get("FromUserName");
        String toUserName = map.get("ToUserName");
        TextMessage textMessage = new TextMessage();
        textMessage.setMsgType(WechatMessageUtil.MESSAGE_TEXT);
        textMessage.setToUserName(fromUserName);
        textMessage.setFromUserName(toUserName);
        textMessage.setCreateTime(System.currentTimeMillis());
        textMessage.setContent(question);
        String responseMessage = WechatMessageUtil.textMessageToXml(textMessage);
        out.print(responseMessage);
        out.flush();
    }

    public void dealCommitQuestion(Map<String, String> map, PrintWriter out) {
        // TODO Auto-generated method stub
        String fromUserName = map.get("FromUserName");
        String toUserName = map.get("ToUserName");
        String answer = map.get("Content");
        String responseMessage = "默认";
        
        TextMessage textMessage = new TextMessage();
        textMessage.setMsgType(WechatMessageUtil.MESSAGE_TEXT);
        textMessage.setToUserName(fromUserName);
        textMessage.setFromUserName(toUserName);
        textMessage.setCreateTime(System.currentTimeMillis());
        String respContent = "";
        if(answer.equals("2")){
            respContent = "回答正确";
        }else{
            respContent = "回答错误";
        }
        textMessage.setContent(respContent);
        responseMessage = WechatMessageUtil.textMessageToXml(textMessage);
        out.print(responseMessage);
        out.flush();
    }

    @Override
    public int insert(Question record) {
        return baseService.getSqlMapper(QuestionMapper.class).insert(record);
    }

}
