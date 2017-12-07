package network.common;  
  

public class ResultBean {  
  
    private Integer flag;  
  
    private String msg;  
  
    private Object data;  

    public ResultBean(){
      
    }
    
    public ResultBean(Integer flag, String msg, Object data){
      this.flag = flag;
      this.msg = msg;
      this.data = data;
    }
    
    public Integer getFlag() {  
        return flag;  
    }  
  
    public void setFlag(Integer flag) {  
        this.flag = flag;  
    }  
  
    public String getMsg() {  
        return msg;  
    }  
  
    public void setMsg(String msg) {  
        this.msg = msg;  
    }  
  
    public Object getData() {  
        return data;  
    }  
  
    public void setData(Object data) {  
        this.data = data;  
    }  
}  