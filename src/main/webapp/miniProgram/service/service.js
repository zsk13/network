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


module.exports = {
  getOpenId,
  getUserInfo,
  getQuestion,
  getCourseName
}