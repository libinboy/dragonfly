layui.config({
	base : "js/"
}).use(['form','jquery','laypage','laydate'],function(){
	var laypage = layui.laypage,
        form = layui.form,
        layer = layui.layer,
        laydate = layui.laydate,
		$ = layui.jquery;

    //监听提交
    form.on('submit(submit)', function(data){
        layer.alert(JSON.stringify(data.field), {
            title: '最终的提交信息'
        });
        return false;
    });

	//加载页面数据
    var url = "/user/list/page";
    var config = {page:1, pageSize:10};
	$.getJSON(url, config, function(res){
        laypage.render({
            elem: 'page',
            count: res.total, //总条数
            limit: config.pageSize, //每页条数
            theme: '#FFB800', //自定义颜色
            jump: function(obj, first){
                if(!first){ //首次则不进入
                    config.page = obj.curr;
                    getUserListByPage(url,config);
                }
            }
        });
		//执行加载数据的方法
        parseUserList(res, config.page);
	});

    //点击页数从后台获取数据
    function getUserListByPage(url, config){
        $.getJSON(url, config, function(res){
            parseUserList(res, config.page);
        });
    }

    //解析数据，currPage参数为预留参数，当删除一行刷新列表时，可以记住当前页而不至于显示到首页去
    function parseUserList(res, currPage){
        var content = "";
        $.each(res.rows, function (i, o) {
            content += '<tr>';
            content += '<td>'+o.account+'</td>';
            content += '<td>'+o.userName+'</td>';
            content += '<td>';
            content +=  '<a class="layui-btn layui-btn-mini user_edit"><i class="iconfont icon-edit"></i> 编辑</a>';
            content += '</td>';
            content += '</tr>';
        });
        $('.users_content').html(content);
    }

    //操作
    $("body").on("click",".user_edit",function(){  //编辑
        layer.alert('您点击了文章编辑按钮，由于是纯静态页面，所以暂时不存在编辑内容，后期会添加，敬请谅解。。。',{icon:6, title:'文章编辑'});
    })
        
})