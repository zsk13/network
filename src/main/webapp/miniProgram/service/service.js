function getOpenId(code) {
  return new Promise(function (resolve, reject) {
    wx.request({
      url: '',
    })
    util.yqrpc('warehouseIOServiceForStd.getOpenId', [code]).then(function (res) {
      var temp = JSON.parse(res.data.result);
      var sessionId = temp.sessionId;

      if (sessionId) {
        console.log('JSESSIONID=' + sessionId);

        getApp().globalData.header.Cookie = 'JSESSIONID=' + sessionId;
        console.log(getApp().globalData.header.Cookie);
      }


      wx.setStorageSync('session_key', temp.session_key);
      wx.setStorageSync('unionid', temp.unionid);
      wx.setStorageSync('openid', temp.openid);
      console.log("openid: " + temp.openid)
      resolve(temp.openid);
    });
  })
}

module.exports = {
  getOpenId,
}