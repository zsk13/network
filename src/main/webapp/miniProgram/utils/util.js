const formatTime = date => {
  const year = date.getFullYear()
  const month = date.getMonth() + 1
  const day = date.getDate()
  const hour = date.getHours()
  const minute = date.getMinutes()
  const second = date.getSeconds()

  return [year, month, day].map(formatNumber).join('/') + ' ' + [hour, minute, second].map(formatNumber).join(':')
}

const formatNumber = n => {
  n = n.toString()
  return n[1] ? n : '0' + n
}

function request(url, data = {}, method = "GET") {
  return new Promise(function (resolve, reject) {
    wx.request({
      url: url,
      data: data,
      method: method,
      header: getApp().globalData.header,
      success: function (res) {
        console.log("success");

        if (res.statusCode == 200) {
          resolve(res.data);
        }
      },
      fail: function (err) {
        reject(err)
        console.log("failed")
      }
    })
  });
}

module.exports = {
  request,
  formatTime: formatTime
}

