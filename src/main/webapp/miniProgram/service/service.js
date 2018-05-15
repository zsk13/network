var util = require('../utils/util.js');
var config = require('../config/config.js');
var syncStore = require('../utils/syncStore.js');
function getOpenid(code) {
  return new Promise(function (resolve, reject) {
    util.request(config.BaseUrl + "miniProgram/getOpenid.do?code=" + code).then(function (res) {
      resolve(res.data);
    })
  });
}
function getUserInfo() {
  return new Promise(function (resolve) {
    var openid = syncStore.getOpenid();
    util.request(config.BaseUrl + "miniProgram/getUserInfo.do?openid=" + openid).then(function (res) {
      console.log(res);
      var userInfo = {
        id: res.data.uId,
        sno: res.data.sno,
        name: res.data.name
      }
      resolve(userInfo);
    })
  })
}

function getQuestion() {
  return new Promise(function (resolve, reject) {
    var openid = syncStore.getOpenid();
    util.request(config.BaseUrl + "miniProgram/getQuestion.do?openid=" + openid).then(function (res) {
      console.log(res);
      resolve(res.data);
    })
  })
}

/**
 *     var course = {
      name: "计算机网络",
      hasRegister: false
    }
 */
function getCourse() {
  return new Promise(function (resolve, reject) {
    var openid = syncStore.getOpenid();
    util.request(config.BaseUrl + "miniProgram/getCourse.do?openid=" + openid).then(function (res) {
      console.log(res);
      if(res.data){
        if(res.data.cName){
          resolve({
            name: res.data.cName,
            hasRegister: false
          });
        }else{
          resolve({
            name: res.data,
            hasRegister: true
          });
        }

      }else{
        resolve({
          name: "",
          hasRegister: false
        });
      }

    })
  })
}

function submitUserInfo(name, sno) {
  return new Promise(function (resolve, reject) {
    var openid = syncStore.getOpenid();
    util.request(config.BaseUrl + "miniProgram/submitUserInfo.do?openid=" + openid + "&name=" + name + "&sno=" + sno).then(function (res) {
      console.log(res);
      resolve(config.success);
    })
  })
}

/**
 * 正确返回success
 * 失败返回error
 */
function submitAnswer(answer) {
  return new Promise(function (resolve, reject) {
    var openid = syncStore.getOpenid();
    util.request(config.BaseUrl + "miniProgram/submitAnswer.do?openid=" + openid + "&answer=" + answer).then(function (res) {
      console.log(res);
      if(res.data){
        resolve("success");
      }else{
        resolve("error")
      }
    })
  })
}

function rollcall(x, y) {
  return new Promise(function (resolve, reject) {
    var openid = syncStore.getOpenid();
    util.request(config.BaseUrl + "miniProgram/rollcall.do?openid=" + openid + "&x=" + x + "&y=" + y).then(function (res) {
      console.log(res);
      var code = res.data
      if (code == 0) {
        resolve("您还没有注册，无法签到")
      } else if (code == 1) {
        resolve("签到失败，当前时间内没有课程！")
      } else if (code == 2) {
        resolve("签到失败，您不在上课地点，请检查定位")
      } else if (code == 3) {
        resolve("签到成功")
      }
    })


  })
}

function getCourses() {
  return new Promise(function (resolve, reject) {
    var openid = syncStore.getOpenid();
    util.request(config.BaseUrl + "miniProgram/getCourses.do?openid=" + openid).then(function (res) {
      console.log(res);
      resolve(res.data);
    })
  });
}

/**
 * 成功返回success
 * 失败返回密码错误
 */
function selectCourse(cId, password) {
  return new Promise(function (resolve, reject) {
    var openid = syncStore.getOpenid();
    util.request(config.BaseUrl + "miniProgram/selectCourse.do?openid=" + openid + "&cId=" + cId + "&password=" + password).then(function (res) {
      console.log(res);
      resolve(res.data);
    })
  });
}


module.exports = {
  getOpenid,
  getUserInfo,
  getQuestion,
  getCourse,
  submitUserInfo,
  submitAnswer,
  rollcall,
  getCourses,
  selectCourse
}