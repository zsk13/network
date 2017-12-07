package common;
/** 
 * @author wrp 
 * @Description com.wrpys.ssm.common.Common 
 * @Date 2017/1/16 
 */  
public class Constants {  
  
    public final static Integer SUCCESS = 1;  
    public final static Integer FAIL = 0;  
    /**
     * token有效期（毫秒数）
     */
    public static final long TOKEN_EXPIRES_TIME = 24*60*60*1000;
  
    public static final String CURRENT_USER_ID = "CURRENT_USER_ID";

    /**
     * 存放Authorization的header字段
     */
    public static final String AUTHORIZATION = "token";
    
    /**
     * 预定状态
     */
    public static final int RESERVESTATE = 0;
    /**
     * 待审批状态
     */
    public static final int TOAPPROVESTATE = 1;
    /**
     * 待执行状态
     */
    public static final int TOFOLLOWSTATE = 2;
    /**
     * 订单完成状态
     */
    public static final int SUCCESSSTATE = 3;
    /**
     * 订单失败状态
     */
    public static final int FAILSTATE = 4;
}  