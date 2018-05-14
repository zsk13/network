package network.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import network.vo.CommonBean;

@Controller
@RequestMapping(value = "miniProgram")
public class MiniProgramCtr {

    @RequestMapping("/first")
    @ResponseBody
    public CommonBean getFirst(){
        CommonBean bean = new CommonBean();
        bean.setResultCode("success");
        bean.setData("this is first message");
        return bean;
    }

    @RequestMapping("/getOpenid")
    @ResponseBody
    public CommonBean getOpenid(String code) throws IOException{
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + "wxeb98926a6249d73b" + "&secret=" + "f77fc9ce8163a716abe1f9b2f114e9f9" + "&js_code=" + code
                + "&grant_type=authorization_code";
        URL urls = new URL(url);  
        HttpURLConnection conn = (HttpURLConnection)urls.openConnection();  
        InputStream inputStream = conn.getInputStream();  
        InputStreamReader read = new InputStreamReader(inputStream, "utf-8");
        //为字符输入流添加缓冲
        BufferedReader br = new BufferedReader(read);  
        // 读取返回结果  
        String data = br.readLine();
        System.out.println(data);
        JSONObject obj =JSONObject.parseObject(data);
        CommonBean bean = new CommonBean();
        bean.setCode(200);
        bean.setData(obj.get("openid"));
        return bean;
    }
    
    @RequestMapping("/getUserInfo")
    @ResponseBody
    public CommonBean getUserInfo(){
        CommonBean bean = new CommonBean();
        bean.setResultCode("success");
        bean.setData("this is first message");
        return bean;
    }
}
