(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["home"],{"16c0":function(e,t,a){"use strict";a.r(t);var n=a("7a23"),r=Object(n["O"])("data-v-0acb66af");Object(n["A"])("data-v-0acb66af");var c={class:"home-container"},s={class:"warpper"},i={class:"header"},o={key:0,class:"buildings"},u={key:1,class:"buildings"};Object(n["y"])();var d=r((function(e,t,a,r,d,m){var b=Object(n["E"])("van-icon"),f=Object(n["E"])("van-calendar");return Object(n["x"])(),Object(n["g"])("div",c,[Object(n["j"])("div",s,[Object(n["j"])("div",i,[Object(n["j"])("div",{class:"header-left",onClick:t[1]||(t[1]=function(){return e.switchCampus&&e.switchCampus.apply(e,arguments)})},[Object(n["i"])(Object(n["H"])(e.campusName(e.state.currrentCampus))+"校区 ",1),Object(n["j"])(b,{name:"exchange",size:"14"})]),Object(n["j"])("div",{class:"header-right",onClick:t[2]||(t[2]=function(t){return e.showCalendar=!0})},Object(n["H"])(e.currentDate),1)]),1==e.state.currrentCampus?(Object(n["x"])(),Object(n["g"])("div",o,[(Object(n["x"])(!0),Object(n["g"])(n["a"],null,Object(n["D"])(e.state.WJL,(function(t,a){return Object(n["x"])(),Object(n["g"])("div",{onClick:function(a){return e.jumpTo("/building",t.building_id)},class:"building-item",key:a},Object(n["H"])(t.building),9,["onClick"])})),128))])):Object(n["h"])("",!0),2==e.state.currrentCampus?(Object(n["x"])(),Object(n["g"])("div",u,[(Object(n["x"])(!0),Object(n["g"])(n["a"],null,Object(n["D"])(e.state.BYY,(function(t,a){return Object(n["x"])(),Object(n["g"])("div",{onClick:function(a){return e.jumpTo("/building",t.building_id)},class:"building-item",key:a},Object(n["H"])(t.building),9,["onClick"])})),128))])):Object(n["h"])("",!0)]),Object(n["j"])(f,{color:"#00a0e9",show:e.showCalendar,"onUpdate:show":t[3]||(t[3]=function(t){return e.showCalendar=t}),onConfirm:e.onConfirm},null,8,["show","onConfirm"])])})),m=(a("9a83"),a("f564")),b=(a("99af"),a("fc62")),f=a("afbc"),l=a("b7c7"),g=[],p=[],j=Object(n["k"])({name:"Home",props:{},setup:function(){var e=Object(n["B"])({currrentCampus:1,BYY:g,WJL:p,firstLoad:!1}),t=function(e){return"".concat(e.getYear()+1900,"年").concat(e.getMonth()+1,"月").concat(e.getDate(),"日")},a=Object(n["C"])(l["a"].get("date")?t(new Date(l["a"].get("date"))):"今天"),r=Object(n["C"])(!1);function c(t){e.BYY=[],e.WJL=[];for(var a=0;a<t.length;a++)"1"===t[a].campus_id?e.WJL.push(t[a]):e.BYY.push(t[a]);e.WJL.sort((function(e,t){return parseInt(e.building)-parseInt(t.building)})),e.BYY.sort((function(e,t){return parseInt(e.building)-parseInt(t.building)}))}function s(e){switch(e){case 1:return"卫津路";case 2:return"北洋园"}}function i(e,t){f["a"].push({path:e,query:{id:t}})}function o(){var t=e.currrentCampus;1===t?e.currrentCampus=2:2===t&&(e.currrentCampus=1)}var u=function(e){var t=l["a"].get("semesterName"),a=l["a"].get("semesterStart"),n=e.getTime(),r=(n/1e3-parseFloat(a))/86400,s={term:t,week:"".concat(Math.floor(r/7)+1),day:"".concat(Math.floor(r%7)+1)};setTimeout((function(){Object(b["a"])(s).then((function(e){var t=e.data;l["a"].set("building",t),c(t)})).catch((function(e){Object(m["a"])({type:"danger",message:e.message})}))}),1e3)},d=function(e){r.value=!1,a.value=t(e),u(e),l["a"].set("date",e)};return{state:e,currentDate:a,campusName:s,switchCampus:o,showCalendar:r,onConfirm:d,onRefresh:u,checkCampus:c,jumpTo:i}},created:function(){var e=this;this.state.firstLoad||Object(b["c"])().then((function(t){var a=t.result;l["a"].set("semesterStart",a.semesterStartTimestamp),l["a"].set("semesterName",a.semesterName);var n=a.semesterName,r=a.semesterStartTimestamp,c=(new Date).getTime(),s=(c/1e3-parseFloat(r))/86400;l["a"].get("date")||l["a"].set("date",new Date);var i={term:n,week:"".concat(Math.floor(s/7)+1),day:"".concat(Math.floor(s%7)+1)};Object(b["a"])(i).then((function(t){var a=t.data;l["a"].set("building",a),e.state.firstLoad=!0,e.checkCampus(a)})).catch((function(e){Object(m["a"])({type:"danger",message:e.message})}))})).catch((function(e){Object(m["a"])({type:"danger",message:"拉取学期信息失败"})}))}});a("b2f6");j.render=d,j.__scopeId="data-v-0acb66af";t["default"]=j},"29e9":function(e,t,a){"use strict";t["a"]={appKey:"lemon",appSecret:"7a858ff32628843043524b729cedfaa70623efc9",domain:"selfstudy.twt.edu.cn",baseURL:"https://selfstudy.twt.edu.cn/",extraBaseUrl:"https://api.twt.edu.cn/"}},"819c":function(e,t,a){},b2f6:function(e,t,a){"use strict";a("819c")},b32d:function(e,t,a){"use strict";var n=a("1da1"),r=(a("e7e5"),a("d399")),c=(a("96cf"),a("99af"),a("d3b7"),a("bc3a")),s=a.n(c),i=a("6ac5"),o=a("b383"),u=a.n(o),d=a("29e9"),m=d["a"].appKey,b=d["a"].appSecret,f=d["a"].domain,l=d["a"].baseURL,g=s.a.create({baseURL:l,timeout:5e3,withCredentials:!0,transformRequest:[function(e,t){if(!t["Content-Type"])return t["Content-Type"]="application/x-www-form-urlencoded",u.a.stringify(e);switch(t["Content-Type"]){case"multipart/form-data":return e;case"application/json":return JSON.stringify(e);default:return u.a.stringify(e)}}],headers:{domain:f,"Access-Control-Allow-Credentials":"true",ticket:window.btoa("".concat(m,".").concat(b))}});g.interceptors.request.use((function(e){return e.loading&&r["a"].loading({message:"加载中...",forbidClick:!0}),e.headers["token"]=Object(i["a"])(),e}),(function(e){Promise.reject(e)})),g.interceptors.response.use(function(){var e=Object(n["a"])(regeneratorRuntime.mark((function e(t){var a;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:if(r["a"].clear(),a=t.data,0===a.error_code){e.next=6;break}return e.abrupt("return",Promise.reject(new Error(a.message||"Error")));case 6:return e.abrupt("return",Promise.resolve(a));case 7:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}(),(function(e){if(r["a"].clear(),e&&e.response)switch(e.response.status){case 400:e.message="请求错误(400)";break;case 401:e.message="未授权,请登录(401)";break;case 403:e.message="拒绝访问(403)";break;case 404:e.message="请求地址出错: ".concat(e.response.config.url);break;case 405:e.message="请求方法未允许(405)";break;case 408:e.message="请求超时(408)";break;case 500:e.message="服务器内部错误(500)";break;case 501:e.message="服务未实现(501)";break;case 502:e.message="网络错误(502)";break;case 503:e.message="服务不可用(503)";break;case 504:e.message="网络超时(504)";break;case 505:e.message="HTTP版本不受支持(505)";break;default:e.message="连接错误: ".concat(e.message)}else"Network Error"==e.message&&e.message,e.message="连接到服务器失败，请联系管理员";return Object(r["a"])(e.message),Promise.reject(e)})),t["a"]=g},b7c7:function(e,t,a){"use strict";a.d(t,"a",(function(){return n}));var n={set:function(e,t){window.sessionStorage.setItem(e,JSON.stringify(t))},get:function(e){var t=window.sessionStorage.getItem(e);return t&&"undefined"!=t&&"null"!=t?JSON.parse(t):null},remove:function(e){window.sessionStorage.removeItem(e)}}},fc62:function(e,t,a){"use strict";a.d(t,"a",(function(){return c})),a.d(t,"b",(function(){return s})),a.d(t,"c",(function(){return i}));a("99af");var n=a("b32d"),r=a("29e9");function c(e){return Object(n["a"])({url:"getDayData/".concat(e.term,"/").concat(e.week,"/").concat(e.day),method:"get"})}function s(e){return Object(n["a"])({url:"getWeekData/".concat(e.term,"/").concat(e.week,"/").concat(e.classroom_id),method:"get"})}function i(){return Object(n["a"])({baseURL:r["a"].extraBaseUrl,url:"/api/semester",method:"get"})}}}]);