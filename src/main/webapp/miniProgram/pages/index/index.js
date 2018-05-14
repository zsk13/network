//index.js
//获取应用实例
const app = getApp()
var service = require('../../service/service.js');
var util = require('../../utils/util.js');
var user = require('../../service/user.js');

Page({
  data: {
    motto: 'Hello World',
    userInfo: {},
  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  onLoad: function () {

    user.loginByWeixin().then(res => {
      app.globalData.userInfo = res;
      this.setData({
        userInfo: app.globalData.userInfo,
      })
    })


  },
  getUserInfo: function(e) {
    console.log(e)
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
    })
  }
})
