(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["home"],{"16c0":function(e,t,a){"use strict";a.r(t);var n=a("7a23"),c=Object(n["O"])("data-v-2bd1bd5e");Object(n["A"])("data-v-2bd1bd5e");var r={class:"home-container"},s={class:"warpper"},i={class:"header"},u={key:0,class:"buildings"},o={key:1,class:"buildings"};Object(n["y"])();var b=c((function(e,t,a,c,b,d){var l=Object(n["E"])("van-icon"),j=Object(n["E"])("van-calendar");return Object(n["x"])(),Object(n["g"])("div",r,[Object(n["j"])("div",s,[Object(n["j"])("div",i,[Object(n["j"])("div",{class:"header-left",onClick:t[1]||(t[1]=function(){return e.switchCampus&&e.switchCampus.apply(e,arguments)})},[Object(n["i"])(Object(n["H"])(e.campusName(e.state.currrentCampus))+"校区 ",1),Object(n["j"])(l,{name:"exchange",size:"14"})]),Object(n["j"])("div",{class:"header-right",onClick:t[2]||(t[2]=function(t){return e.showCalendar=!0})},Object(n["H"])(e.currentDate),1)]),1==e.state.currrentCampus?(Object(n["x"])(),Object(n["g"])("div",u,[(Object(n["x"])(!0),Object(n["g"])(n["a"],null,Object(n["D"])(e.state.WJL,(function(t,a){return Object(n["x"])(),Object(n["g"])("div",{onClick:function(a){return e.jumpTo("/building",t.building_id)},class:"building-item",key:a},Object(n["H"])(t.building),9,["onClick"])})),128))])):Object(n["h"])("",!0),2==e.state.currrentCampus?(Object(n["x"])(),Object(n["g"])("div",o,[(Object(n["x"])(!0),Object(n["g"])(n["a"],null,Object(n["D"])(e.state.BYY,(function(t,a){return Object(n["x"])(),Object(n["g"])("div",{onClick:function(a){return e.jumpTo("/building",t.building_id)},class:"building-item",key:a},Object(n["H"])(t.building),9,["onClick"])})),128))])):Object(n["h"])("",!0)]),Object(n["j"])(j,{color:"#00a0e9",show:e.showCalendar,"onUpdate:show":t[3]||(t[3]=function(t){return e.showCalendar=t}),onConfirm:e.onConfirm},null,8,["show","onConfirm"])])})),d=(a("9a83"),a("f564")),l=(a("99af"),a("fc62")),j=a("afbc"),m=a("b7c7"),f=[],g=[],p=Object(n["k"])({name:"Home",props:{},setup:function(){var e=Object(n["B"])({currrentCampus:1,BYY:f,WJL:g,firstLoad:!1}),t=function(e){return"".concat(e.getYear()+1900,"年").concat(e.getMonth()+1,"月").concat(e.getDate(),"日")},a=Object(n["C"])(m["a"].get("date")?t(new Date(m["a"].get("date"))):"今天"),c=Object(n["C"])(!1),r=function(e){c.value=!1,a.value=t(e),b(e),m["a"].set("date",e)};function s(t){e.BYY=[],e.WJL=[];for(var a=0;a<t.length;a++)"1"===t[a].campus_id?e.WJL.push(t[a]):e.BYY.push(t[a]);e.WJL.sort((function(e,t){return parseInt(e.building)-parseInt(t.building)})),e.BYY.sort((function(e,t){return parseInt(e.building)-parseInt(t.building)}))}function i(e){switch(e){case 1:return"卫津路";case 2:return"北洋园"}}function u(e,t){j["a"].push({path:e,query:{id:t}})}function o(){var t=e.currrentCampus;1===t?e.currrentCampus=2:2===t&&(e.currrentCampus=1)}var b=function(e){var t=m["a"].get("semesterName"),a=m["a"].get("semesterStart"),n=e.getTime(),c=(n/1e3-parseFloat(a))/86400,r={term:t,week:"".concat(Math.floor(c/7)+1),day:"".concat(Math.floor(c%7)+1)};setTimeout((function(){Object(l["a"])(r).then((function(e){var t=e.data;m["a"].set("building",t),s(t)})).catch((function(e){Object(d["a"])({type:"danger",message:e.message})}))}),1e3)};return{state:e,currentDate:a,campusName:i,switchCampus:o,showCalendar:c,onConfirm:r,onRefresh:b,checkCampus:s,jumpTo:u}},created:function(){var e=this;if(!this.state.firstLoad&&m["a"].get("semesterName")){var t=m["a"].get("semesterName"),a=m["a"].get("semesterStart"),n=(new Date).getTime(),c=(n/1e3-parseFloat(a))/86400;m["a"].get("date")||m["a"].set("date",new Date);var r={term:t,week:"".concat(Math.floor(c/7)+1),day:"".concat(Math.floor(c%7)+1)};Object(l["a"])(r).then((function(t){var a=t.data;m["a"].set("building",a),e.state.firstLoad=!0,e.checkCampus(a)})).catch((function(e){Object(d["a"])({type:"danger",message:e.message})}))}}});a("65dc");p.render=b,p.__scopeId="data-v-2bd1bd5e";t["default"]=p},"65dc":function(e,t,a){"use strict";a("b4eb")},b4eb:function(e,t,a){}}]);