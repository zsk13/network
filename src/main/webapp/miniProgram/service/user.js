var service = require('../service/service.js');
var util = require('../utils/util.js');


function loginByWeixin() {
  let code = null;
  return new Promise(function (resolve, reject) {
    return util.login().then((res) => {
      console.log("code: " + res.code);
      code = res.code;
      return new Promise(function (resolve, reject) {
        resolve(code);
      })
    }).then((code) => {
      wx.setStorageSync('code', code);
      return service.getOpenid(code);
    }).then((openId) => {
      wx.setStorageSync('userOpenId', openId);
      return util.getUserInfo();
    }).then((userInfo) => {
      wx.setStorageSync('userInfo', userInfo.userInfo);
      resolve(userInfo.userInfo);
    }).catch((err) => {
      reject(err);
    })
  });
}

module.exports = {
  loginByWeixin
}