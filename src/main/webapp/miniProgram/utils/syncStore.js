function getOpenid() {
  var openid = wx.getStorageSync('userOpenId');
  return openid;
}


module.exports = {
 getOpenid,
}