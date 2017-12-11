package network.service.impl;

import network.common.wechatUtil.TextMessage;
import network.common.wechatUtil.WechatMessageUtil;
import network.dao.UsersDao;
import network.model.Users;
import network.service.FollowService;

import java.io.PrintWriter;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowServiceImpl implements FollowService {
    @Autowired
    private UsersDao usersDao;

    public void follow(String content) {
        int index = content.indexOf(",");
        String sno = content.substring(3, index);
        String name = content.substring(index + 4);
        Users users = new Users();
        users.setSno(sno);
        users.setName(name);
        usersDao.insert(users);
    }

    @Override
    public void follow(Map<String, String> map, PrintWriter out, String content) {
        String fromUserName = map.get("FromUserName");
        String toUserName = map.get("ToUserName");
        TextMessage textMessage = new TextMessage();
        textMessage.setMsgType(WechatMessageUtil.MESSAGE_TEXT);
        textMessage.setToUserName(fromUserName);
        textMessage.setFromUserName(toUserName);
        textMessage.setCreateTime(System.currentTimeMillis());


        try {
            String[] ss = content.split(" ");
            String sno = ss[1];
            String name = ss[3];
            Users users = new Users();
            users.setuOpenId(fromUserName);
            users.setSno(sno);
            users.setName(name);
            usersDao.insert(users);
            textMessage.setContent("注册成功");
        } catch (Exception e) {
            e.printStackTrace();
            textMessage.setContent("格式应该为 学号 MF1732222 姓名 张三");
        }
        String responseMessage = WechatMessageUtil.textMessageToXml(textMessage);
        out.print(responseMessage);
        out.flush();
    }
}
