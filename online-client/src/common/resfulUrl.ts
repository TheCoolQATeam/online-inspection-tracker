/**
 * e.g:
 * params={userId:"1",userName:"tom",userAge:18}
 * url='/user/{userId}/{usreName}'
 * ---------------------------------------------
 * url convert to '/user/1/tom'
 * not matched parameter:"userAge" will be sent to Server as request params :{userAge:18}
 */
export function resfulParamsToUrl(url: string, params: { [key: string]: any }) {
  if (!/{*}/g.test(url)) {
    return url;
  } else if (params === undefined || (typeof params == "object" && Object.keys(params).length == 0)) {
    console.warn(`url:${url} contain unconverted parameters,but the parmas in arguments is undefined or an empty object`)
    return url.slice(0, url.indexOf('{'));
  } else {
    let {keys} = Object;
    for (let key of keys(params)) {
      let reg = new RegExp('{' + key + '}', 'g')
      if (reg.test(url)) {
        url = url.replace(reg, encodeURIComponent(params[key]));
        delete params[key];
      }
    }
    if (/{*}/g.test(url)) {
      console.warn(`url:${url} contain unconverted parameters at the last moment`)
    }
  }
  return url;
};

