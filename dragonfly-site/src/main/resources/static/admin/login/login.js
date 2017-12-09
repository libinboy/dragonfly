layui.config({
    version: "3.0.0"
	,base : "/mods/admin/"
}).use(['form', 'layer'],function(){
	var form = layui.form,
		$ = layui.jquery;
    	layer = parent.layer === undefined ? layui.layer : parent.layer,
	//video背景
	$(window).resize(function(){
		if($(".video-player").width() > $(window).width()){
			$(".video-player").css({"height":$(window).height(),"width":"auto","left":-($(".video-player").width()-$(window).width())/2});
		}else{
			$(".video-player").css({"width":$(window).width(),"height":"auto","left":-($(".video-player").width()-$(window).width())/2});
		}
	}).resize();
	
	//登录按钮事件
	form.on("submit(login)",function(data){
        $.post('/login/authenticate', data.field, function(res){
        	if (res.status == "200") {
                window.location.href = "../../index.html";
			} else {
                layer.msg(res.message);
            }

        });
        return false;
	});

    // 刷新验证码
    $("#kaptcha").on("click",function(){
        $("#kaptcha").attr("src","/images/kaptcha.jpg?t=" + Math.random());
    })
})
