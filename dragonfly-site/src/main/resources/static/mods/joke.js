/**
 @Name: 笑话板块
 */ 
layui.define('fly', function(exports){

	var $ = layui.jquery;
	var layer = layui.layer;
	var util = layui.util;
	var laytpl = layui.laytpl;
	var form = layui.form;
	var fly = layui.fly; 
	
	var gather = {}, dom = {
	};
  
	var tpl = '<li>\
		<a href="user/home.html" class="fly-avatar">\
		  <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" alt="dragonfly">\
		</a>\
		<div>\
		  <a href="detail.html">{{d.data.jokeContent}}</a>\
		</div>\
		<div class="fly-list-info">\
		  <a href="user/home.html" link>\
			<cite>dragonfly</cite>\
		  </a>\
		  <span>刚刚</span>\
		  <span class="fly-list-kiss layui-hide-xs" title="悬赏飞吻"><i class="iconfont icon-kiss"></i> 60</span>\
              <span class="layui-badge fly-badge-accept layui-hide-xs">已结</span>\
		  <span class="fly-list-nums">\
			<i class="iconfont icon-pinglun1" title="回答"></i> 66\
		  </span>\
		</div>\
    </li>';
	
	//异步渲染, 加载列表
	fly.json('../../json/joke_json.js', function(res){
		var joke_list_html = "";
		layui.each(res.data, function(index, item){				
			var html = laytpl(tpl).render({
			  data: item
			  ,index: index
			});
			joke_list_html += html;
			if (index == (res.data.length - 1)) {
				return true;
			}
		});
		$("#joke-fly-list").html(joke_list_html);
    }, {type: 'get'});
	
	exports('joke', null);	
	
});