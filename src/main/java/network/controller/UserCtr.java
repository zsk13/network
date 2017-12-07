package network.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import network.common.Constants;
import network.common.PageInfo;
import network.common.ResultBean;
import network.model.User;
import network.service.UserService;



@Controller
@RequestMapping(value = "user")
@Validated
public class UserCtr {

  Log logger = LogFactory.getLog(UserCtr.class);

  @Autowired
  private UserService userService;

  @RequestMapping(value = "list", method = {RequestMethod.GET})
  @ResponseBody
  public PageInfo findUser(PageInfo pageInfo, User user) {
    pageInfo = new PageInfo(pageInfo);
    userService.findUser(pageInfo, user);
    return pageInfo;
  }

  @RequestMapping(value = "", method = {RequestMethod.POST})
  @ResponseBody
  public ResultBean create(User user) {
    ResultBean rb = new ResultBean();
    userService.createUser(user);
    rb.setFlag(Constants.SUCCESS);
    return rb;
  }

  @RequestMapping(value = "add", method = {RequestMethod.GET, RequestMethod.POST})
  @ResponseBody
  public ResultBean add(User user) {
    ResultBean rb = new ResultBean();
    userService.createUser(user);
    rb.setFlag(Constants.SUCCESS);
    return rb;
  }

  @RequestMapping(value = "delete", method = {RequestMethod.GET, RequestMethod.POST})
  @ResponseBody
  public ResultBean delete(User user) {
    ResultBean rb = new ResultBean();
    userService.deleteUser(user);
    rb.setFlag(Constants.SUCCESS);
    return rb;
  }

  @RequestMapping(value = "batchDeleteUser", method = {RequestMethod.GET, RequestMethod.POST})
  @ResponseBody

  public ResultBean batchDeleteUser(@RequestParam(value = "userIds")  List<Integer> userIds) {
    throw new NullPointerException();
//    ResultBean rb = new ResultBean();
//    userService.batchDeleteUser(userIds);
//    rb.setFlag(Constants.SUCCESS);
//    return rb;
  }

  @RequestMapping(value = "update", method = {RequestMethod.GET, RequestMethod.POST})
  @ResponseBody
  public ResultBean update(User user) {
    ResultBean rb = new ResultBean();
    userService.updateUser(user);
    rb.setFlag(Constants.SUCCESS);
    return rb;
  }
  
  @RequestMapping(value = "find", method = {RequestMethod.GET, RequestMethod.POST})
  @ResponseBody
  public User findUserById(User user) {
    User rb = userService.findUserById(user.getUserId());
    return rb;
  }

}
