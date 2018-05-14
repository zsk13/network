// pages/register/register.js
var service = require('../../service/service.js');
Page({

  /**
   * 页面的初始数据
   */
  data: {
    courseName: "",
    hasRegister: ""
  },
  /**
   * 签到
   */
  register(event) {
    let that = this;
    let x;
    let y;
    wx.getLocation({
      type: 'wgs84',
      success: function (res) {
        console.log(res)
        x = res.latitude
        y = res.longitude
        
        service.rollcall(x, y).then(function (res) {
          wx.showToast({
            icon: 'none',
            title: res,
            duration: 2000,
            mask: true
          })
          service.getCourse().then(function (res) {
            that.setData({
              hasRegister: res.hasRegister
            });
          })
        })
      }
    }) 
   
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    let that = this;
    service.getCourse().then(function (res) {
      that.setData({
        courseName: res.name,
        hasRegister: res.hasRegister
      });
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})