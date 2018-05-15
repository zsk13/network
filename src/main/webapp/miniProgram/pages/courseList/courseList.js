// pages/courseList/courseList.js
var service = require('../../service/service.js');
Page({

  /**
   * 页面的初始数据
   */
  data: {
    courseList:"",
    password:"",
    courseId:"",

    showModalStatus: false,
    animation:"",
  },
  /**
   * 选课
   */
  selectCourse(event){
    let id = event.currentTarget.dataset.id
    //console.log(id)
    this.setData({
      courseId: id
    });
    this.showModal();
  },
  /**
   * 绑定用户输入
   */
  bindAnswer(event) {
    let answer = event.detail.value;
    this.setData({
      password: answer
    });
  },
  /**
   * 提交选课结果
   */
  submit(event) {
    let that = this;
    
    service.selectCourse(this.data.courseId, this.data.password).then(function (res) {
      that.hideModal();
      if (res == 'success') {
        wx.showToast({
          icon: 'none',
          title: '选课成功',
          duration: 2000,
          mask: true
        })
      }
      else {
        wx.showToast({
          icon: 'none',
          title: ' 选课密码错误',
          duration: 2000,
          mask: true
        })
      }
      service.getCourses().then(function (res) {
        that.setData({
          courseList: res,
          password:"",
          courseId:"",
        });
      })
    })
    
  },
  showModal: function () {
    // 显示遮罩层
    var animation = wx.createAnimation({
      duration: 200,
      timingFunction: "linear",
      delay: 0
    })
    this.animation = animation
    animation.translateY(300).step()
    this.setData({
      animationData: animation.export(),
      showModalStatus: true
    })
    setTimeout(function () {
      animation.translateY(0).step()
      this.setData({
        animationData: animation.export()
      })
    }.bind(this), 200)
  },
  hideModal: function () {
    // 隐藏遮罩层
    var animation = wx.createAnimation({
      duration: 200,
      timingFunction: "linear",
      delay: 0
    })
    this.animation = animation
    animation.translateY(300).step()
    this.setData({
      animationData: animation.export(),
      showModalStatus: false
    })
    setTimeout(function () {
      animation.translateY(0).step()
      this.setData({
        animationData: animation.export(),
        showModalStatus: false
      })
    }.bind(this), 200)
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    let that = this;
    service.getCourses().then(function (res) {
      that.setData({
        courseList: res
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