// 获取cookie值
export const getCookie = (cname: any) => {
  const name = cname + '='
  const ca = document.cookie.split(';')
  for (let i = 0; i < ca.length; i++) {
    const c = ca[i].trim()
    if (c.indexOf(name) == 0) {
      return decodeURI(c.substring(name.length, c.length))
    }
  }
  return ''
}

export const clearCookie = () => {
  const keys = document.cookie.match(/[^ =;]+(?=\=)/g)
  if (keys) {
    for (let i = 0; i < keys.length; i++) {
      console.log(keys[i] + '=0;path=/;expires=' + new Date(0).toUTCString())
      document.cookie = keys[i] + '=0;path=/;expires=' + new Date(0).toUTCString()// 清除当前域名下的
      // document.cookie = keys[i] + '=0;path=/;domain=' + document.domain + ';expires=' + new Date(0).toUTCString();//清除当前域名下的
      // document.cookie = keys[i] + '=0;path=/;domain=kevis.com;expires=' + new Date(0).toUTCString();//清除一级域名下的或指定的，例如 .kevis.com
    }
    console.log(document.cookie)
  }
}

// 格式化时间
export const formateDate = (timestamp: number, type = 'short') => {
  if (!timestamp) return ''
  const date = new Date(timestamp)
  const y = date.getFullYear()
  const m = (date.getMonth() + 1) < 10 ? '0' + (date.getMonth() + 1) : (date.getMonth() + 1)
  const d = date.getDate() < 10 ? '0' + date.getDate() : date.getDate()
  if (type == 'short') {
    return (y + '-' + m + '-' + d)
  }
  const h = date.getHours() < 10 ? '0' + date.getHours() : date.getHours()
  const min = date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes()
  const s = date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds()
  return (y + '-' + m + '-' + d + '  ' + h + ':' + min + ':' + s)
}

interface Groups {
  [key: number]: string;
}
export const getGroup = (group: number) => {
  const groups = {
    1: '分组A',
    2: '分组B'
  } as Groups
  return groups[group] ? groups[group] : ''
}

export const msToMinutes = (ms: number) => {
  const minutes = parseInt((ms % (1000 * 60 * 60)) / (1000 * 60) + '')
  const seconds = ((ms % (1000 * 60)) / 1000).toFixed(0)
  return minutes + ' 分 ' + seconds + ' 秒 '
}
