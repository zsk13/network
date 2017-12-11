package network.service;

import java.io.PrintWriter;
import java.util.Map;

/*
    用户关注后增加用户学号姓名
 */
public interface FollowService {
    void follow(Map<String, String> map, PrintWriter out, String content);
}
