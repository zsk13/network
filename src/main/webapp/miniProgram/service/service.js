var util = require('../utils/util.js');
function getOpenId(code) {
  return new Promise(function (resolve, reject) {
    util.request("http://www.ufeng.top/network/miniProgram/first.do").then(function (res) {
      resolve(res);
    })
  });
}
function getUserInfo(){
  return new Promise(function(resolve){
    var userInfo = {
      id : 1,
      sno : "MF1732173",
      name : "张苏可"
    }
    resolve(userInfo)
  })
}

function getQuestion() {
  return new Promise(function (resolve, reject) {
    resolve("1+1=?");
  })
}

function getCourseName(){
  return new Promise(function (resolve, reject) {
    resolve("计算机网络");
  })
}

function submitUserInfo(name,sno){
  return new Promise(function (resolve, reject) {
    resolve("success");
  })
}

function submitAnswer(answer) {
  return new Promise(function (resolve, reject) {
    if(answer == 2){
      resolve("success");
    }else{
      resolve("error")
    }
  })
}

function rollcall(x,y){
  return new Promise(function (resolve, reject) {
    var code = 3;
    if(code==0){
      resolve("您还没有注册，无法签到")
    } else if (code == 1) {
      resolve("签到失败，当前时间内没有课程！")
    }else if (code == 2) {
      resolve("签到失败，您不在上课地点，请检查定位")
    }else if (code == 3) {
      resolve("签到成功")
    }
  })
}


module.exports = {
  getOpenId,
  getUserInfo,
  getQuestion,
  getCourseName,
  submitUserInfo,
  submitAnswer,
  rollcall
}