var service = require('../../service/service.js');
var config = require('../../config/config.js');

// pages/binding/infoBinding.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    schoolNum: "",
    name: "",
    hasBinded: false,
    disabled: true,
    opacity: 0.4,
  },

  isSchoolNum:function(str){  //判断学号输入长度是否符合规则
    if(str != null) {
      var len = str.length;
      if (len == 9) {
        return true;
      } else {
        return false;
      }
    }
  },

  schoolNum:function(event){
    var isNum = this.isSchoolNum(event.detail.value)
    if (isNum) {
      this.setData({
        disabled: false,
        opacity: 1
      })
    } else {
      this.setData({
        disabled: true,
        opacity: 0.4
      })
    }
  },

  submit:function(event){
    let that = this;
    var n = event.detail.value.name
    var sno = event.detail.value.schoolNum
    // debugger;
    if (n.length == 0) {
      wx.showModal({
        title: '',
        content: '请填写姓名',
        showCancel: false
      })
    } else {
      // wx.showModal({
      //   title: '学号：' + sno + '  ' + '姓名：' + n,
      //   showCancel: false
      // })
      this.setData({
        name: n,
        schoolNum: sno
      })
      service.submitUserInfo(n, sno).then(function(res){
        if (res == config.success) {
          wx.showModal({
            title: '绑定成功',
            showCancel: false,
            success:function(){
              that.setData({
                hasBinded: true
              })
            }
          })
        }
      })
    }
  },

  resetInfo: function() {
    let that = this;
    wx.showModal({
      title: '确定重新绑定？',
      showCancel: true,
      success: function(res) {
        if(res.confirm) {
          that.setData({
            hasBinded: false,
            name: "",
            schoolNum: "",
            disabled: true
          })
        }
      }
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    let that = this;
    service.getUserInfo().then(function(res){
      if (res.id) {
        that.setData({
          name: res.name,
          schoolNum: res.sno,
          hasBinded: res.name
        })
      }
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