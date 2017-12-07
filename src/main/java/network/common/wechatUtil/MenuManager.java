package network.common.wechatUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MenuManager {
    private static Log log = LogFactory.getLog(MenuManager.class);

    public static void main(String[] args) {
        // 调用接口获取access_token
        Token token = TokenUtil.getToken();

        if (null != token) {
            // 调用接口创建菜单
            int result = WeixinUtil.createMenu(getMenu(), token.getAccessToken());

            // 判断菜单创建结果
            if (0 == result)
                log.info("菜单创建成功！");
            else
                log.info("菜单创建失败，错误码：" + result);
        }
    }

    /**
     * 组装菜单数据
     * 
     * @return
     */
    private static Menu getMenu() {
        CommonButton btn11 = new CommonButton();
        btn11.setName("签到");
        btn11.setType("click");
        btn11.setKey("11");

        CommonButton btn12 = new CommonButton();
        btn12.setName("课堂练习");
        btn12.setType("click");
        btn12.setKey("12");
        
        /**
         * 微信：  mainBtn1,mainBtn2,mainBtn3底部的三个一级菜单。
         */
        
//        ComplexButton mainBtn1 = new ComplexButton();
//        mainBtn1.setName("生活助手");
//        //一级下有4个子菜单
//        mainBtn1.setSub_button(new CommonButton[] { btn11, btn12, btn13, btn14 });
//
//        
//        ComplexButton mainBtn2 = new ComplexButton();
//        mainBtn2.setName("休闲驿站");
//        mainBtn2.setSub_button(new CommonButton[] { btn21, btn22, btn23, btn24, btn25 });
//
//        
//        ComplexButton mainBtn3 = new ComplexButton();
//        mainBtn3.setName("更多体验");
//        mainBtn3.setSub_button(new CommonButton[] { btn31, btn32, btn33 });

        
        /**
         * 封装整个菜单
         */
        Menu menu = new Menu();
        menu.setButton(new Button[] { btn11, btn12 });

        return menu;
    }
}
