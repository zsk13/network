package network.controller;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    
}
